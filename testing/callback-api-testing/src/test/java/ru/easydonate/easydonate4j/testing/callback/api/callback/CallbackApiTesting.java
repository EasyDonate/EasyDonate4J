package ru.easydonate.easydonate4j.testing.callback.api.callback;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import ru.easydonate.easydonate4j.callback.client.CallbackApiClient;
import ru.easydonate.easydonate4j.callback.data.model.payment.Payment;
import ru.easydonate.easydonate4j.callback.event.CallbackListener;
import ru.easydonate.easydonate4j.callback.event.Listen;
import ru.easydonate.easydonate4j.callback.event.type.IncomingPaymentEvent;
import ru.easydonate.easydonate4j.json.serialization.JacksonSerializationService;
import ru.easydonate.easydonate4j.testing.callback.api.TestingFramework;
import ru.easydonate.easydonate4j.testing.callback.api.TestingModule;
import ru.easydonate.easydonate4j.testing.callback.api.ordering.TestClassesOrder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

@TestClassesOrder(2)
@DisplayName("Callback API Testing")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public final class CallbackApiTesting extends TestingModule implements CallbackListener {

    private static CompletableFuture<Payment> requestFuture;

    private final CallbackApiClient client;
    private Payment cachedRequest;

    public CallbackApiTesting() {
        this.client = CallbackApiClient.create(TestingFramework.getApiKey(), false);
        this.client.registerListener(this);
    }

    @BeforeAll
    public static void preInit() {
        if(!JacksonSerializationService.isRegistered())
            JacksonSerializationService.register();
    }

    @Test
    @Order(1)
    @DisplayName("Callback incoming JSON request parsing")
    public void parseIncomingRequest() {
        InputStream jsonResource = getClass().getResourceAsStream("/json/callback/api/request.json");
        Assertions.assertNotNull(jsonResource, "'jsonResource' is null");

        InputStreamReader inputStreamReader = new InputStreamReader(jsonResource, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String content = bufferedReader.lines().collect(Collectors.joining("\n"));

        try {
            requestFuture = new CompletableFuture<>();
            client.processIncomingPayment(content);
        } catch (Exception ex) {
            requestFuture.complete(null);
            Assertions.fail("An error has occurred while trying to parse the incoming JSON request!", ex);
        }
    }

    @Test
    @Order(2)
    @DisplayName("Payment request signature validation")
    public void validatePaymentRequestSignature() throws ExecutionException, InterruptedException, TimeoutException {
        if(requestFuture == null)
            Assertions.fail("cached request future field isn't initialized");

        logger.info("Awaiting for request deserialization result...");
        Payment payment = requestFuture.get(10, TimeUnit.SECONDS);
        Assertions.assertNotNull(payment, "'payment' is null");

        requestFuture = null;

        String receivedSignature = payment.getSignature();
        Assertions.assertNotNull(receivedSignature, "'receivedSignature' is null");

        String generatedSignature = payment.getSignatureFromData(client.getAccessKey()).compile();
        Assertions.assertNotNull(generatedSignature, "'generatedSignature' is null");

        Assertions.assertEquals(receivedSignature, generatedSignature);
        logger.info("Signature validation passed successfully!");
    }

    @Listen
    public void onIncomingRequestReceived(@NotNull IncomingPaymentEvent event) {
        if(requestFuture != null)
            requestFuture.complete(event.getPayment());
    }

}
