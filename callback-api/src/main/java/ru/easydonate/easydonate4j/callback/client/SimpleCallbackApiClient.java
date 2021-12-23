package ru.easydonate.easydonate4j.callback.client;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.Constants;
import ru.easydonate.easydonate4j.callback.data.model.payment.Payment;
import ru.easydonate.easydonate4j.callback.event.CallbackListener;
import ru.easydonate.easydonate4j.callback.event.EventBus;
import ru.easydonate.easydonate4j.callback.event.type.IncomingPaymentEvent;
import ru.easydonate.easydonate4j.callback.exception.InvalidEventHandlerException;
import ru.easydonate.easydonate4j.callback.exception.SignatureGenerationException;
import ru.easydonate.easydonate4j.callback.exception.SignatureVerificationException;
import ru.easydonate.easydonate4j.callback.signature.Signature;
import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationService;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.util.Validate;

@Getter
public final class SimpleCallbackApiClient implements CallbackApiClient {

    private static final String API_ENDPOINT = "https://easydonate.ru/api/v3/%s";
    private static final String PLUGIN_API_ENDPOINT = "https://easydonate.ru/api/v3/plugin/%s/%s";

    private final String accessKey;
    private final boolean signatureVerificationEnabled;
    private final EventBus eventBus;

    private final JsonSerializationService jsonSerialization;

    SimpleCallbackApiClient(@NotNull String accessKey, int eventBusAsyncThreadPoolSize, boolean signatureVerificationEnabled) {
        this.accessKey = accessKey;
        this.signatureVerificationEnabled = signatureVerificationEnabled;
        this.eventBus = new EventBus(eventBusAsyncThreadPoolSize);

        this.jsonSerialization = ModuleRegistrator.jsonSerializationService();
        this.jsonSerialization.registerImplementationAliasesGroup(JsonModelsGroup.CALLBACK_API_MODELS);
    }

    @Override
    public void registerListener(@NotNull CallbackListener callbackListener) throws InvalidEventHandlerException {
        eventBus.registerListeners(callbackListener);
    }

    @Override
    public void processIncomingPayment(@NotNull String requestBody)
            throws JsonSerializationException, SignatureGenerationException, SignatureVerificationException
    {
        Payment payment = jsonSerialization.deserialize(Payment.class, requestBody);
        Signature signature = null;

        if(signatureVerificationEnabled) {
            String receivedSignature = payment.getSignature();
            if(receivedSignature == null || receivedSignature.isEmpty())
                throw new SignatureVerificationException("There are no signature was received from the request body!");

            signature = payment.getSignatureFromData(accessKey);
            String generatedSignature = signature.compile();

            if(!receivedSignature.equalsIgnoreCase(generatedSignature))
                throw new SignatureVerificationException("Signatures mismatch! received: '%s', generated: '%s'", receivedSignature, generatedSignature);
        }

        new IncomingPaymentEvent(this, payment, signature).fire();
    }

    @Override
    public @NotNull String toString() {
        return "SimpleCallbackApiClient{" +
                "accessKey='" + accessKey + '\'' +
                ", signatureVerificationEnabled=" + signatureVerificationEnabled +
                ", jsonSerialization=" + jsonSerialization +
                '}';
    }

    static final class SimpleBuilder implements CallbackApiClient.Builder {

        private String accessKey;
        private int eventBusAsyncThreadPoolSize = Constants.EVENT_BUS_ASYNC_THREAD_POOL_SIZE;
        private boolean signatureVerificationEnabled = Constants.SIGNATURE_VERIFICATION_ENABLED;

        @Override
        public @NotNull CallbackApiClient create() {
            return new SimpleCallbackApiClient(accessKey, eventBusAsyncThreadPoolSize, signatureVerificationEnabled);
        }

        @Override
        public @NotNull Builder setAccessKey(@NotNull String accessKey) {
            Validate.notEmpty(accessKey, "accessKey");
            this.accessKey = accessKey;
            return this;
        }

        @Override
        public @NotNull Builder setEventBusAsyncThreadPoolSize(int eventBusAsyncThreadPoolSize) {
            this.eventBusAsyncThreadPoolSize = Math.max(eventBusAsyncThreadPoolSize, 0);
            return this;
        }

        @Override
        public @NotNull Builder setSignatureVerificationEnabled(boolean signatureVerificationEnabled) {
            this.signatureVerificationEnabled = signatureVerificationEnabled;
            return this;
        }

    }

}
