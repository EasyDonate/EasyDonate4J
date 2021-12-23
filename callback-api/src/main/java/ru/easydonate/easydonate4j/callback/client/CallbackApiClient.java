package ru.easydonate.easydonate4j.callback.client;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.Constants;
import ru.easydonate.easydonate4j.callback.event.CallbackListener;
import ru.easydonate.easydonate4j.callback.event.EventBus;
import ru.easydonate.easydonate4j.callback.exception.InvalidEventHandlerException;
import ru.easydonate.easydonate4j.callback.exception.SignatureGenerationException;
import ru.easydonate.easydonate4j.callback.exception.SignatureVerificationException;
import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationService;

public interface CallbackApiClient {

    static @NotNull CallbackApiClient create(@NotNull String accessKey) {
        return create(accessKey, Constants.EVENT_BUS_ASYNC_THREAD_POOL_SIZE, Constants.SIGNATURE_VERIFICATION_ENABLED);
    }

    static @NotNull CallbackApiClient create(@NotNull String accessKey, boolean signatureVerificationEnabled) {
        return create(accessKey, Constants.EVENT_BUS_ASYNC_THREAD_POOL_SIZE, signatureVerificationEnabled);
    }

    static @NotNull CallbackApiClient create(
            @NotNull String accessKey,
            int eventBusAsyncThreadPoolSize,
            boolean signatureVerificationEnabled
    ) {
        return builder()
                .setAccessKey(accessKey)
                .setEventBusAsyncThreadPoolSize(eventBusAsyncThreadPoolSize)
                .setSignatureVerificationEnabled(signatureVerificationEnabled)
                .create();
    }

    static @NotNull CallbackApiClient.Builder builder() {
        return new SimpleCallbackApiClient.SimpleBuilder();
    }

    @NotNull String getAccessKey();

    boolean isSignatureVerificationEnabled();

    @NotNull EventBus getEventBus();

    @NotNull JsonSerializationService getJsonSerialization();

    void registerListener(@NotNull CallbackListener callbackListener) throws InvalidEventHandlerException;

    void processIncomingPayment(@NotNull String requestBody) throws JsonSerializationException, SignatureGenerationException, SignatureVerificationException;

    interface Builder {

        @NotNull CallbackApiClient create();

        @NotNull Builder setAccessKey(@NotNull String accessKey);

        @NotNull Builder setEventBusAsyncThreadPoolSize(int eventBusAsyncThreadPoolSize);

        @NotNull Builder setSignatureVerificationEnabled(boolean signatureVerificationEnabled);

    }
    
}
