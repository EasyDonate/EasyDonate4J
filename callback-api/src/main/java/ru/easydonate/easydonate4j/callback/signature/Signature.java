package ru.easydonate.easydonate4j.callback.signature;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.data.model.payment.Payment;
import ru.easydonate.easydonate4j.callback.exception.SignatureGenerationException;
import ru.easydonate.easydonate4j.util.Validate;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface Signature {

    static @NotNull Signature paymentHmac(
            @NotNull String accessKey,
            @NotNull Payment payment
    ) throws SignatureGenerationException {
        Validate.notEmpty(accessKey, "accessKey");
        Validate.notNull(payment, "payment");

        try {
            return new PaymentHmacSignature(accessKey, payment);
        } catch (NoSuchAlgorithmException | InvalidKeyException ex) {
            throw new SignatureGenerationException(ex);
        }
    }

    @NotNull String compile();

    boolean compareWithReceived(@NotNull String receivedSignature);

}
