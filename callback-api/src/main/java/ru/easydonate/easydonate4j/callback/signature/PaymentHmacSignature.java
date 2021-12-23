package ru.easydonate.easydonate4j.callback.signature;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.data.model.payment.Payment;
import ru.easydonate.easydonate4j.callback.signature.hashed.HmacSHA256Signature;
import ru.easydonate.easydonate4j.util.Validate;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

final class PaymentHmacSignature extends HmacSHA256Signature implements Signature {

    private static final String RAW_STRING_FORMAT = "%d@%s@%s";

    private final Payment payment;

    public PaymentHmacSignature(
            @NotNull String accessKey,
            @NotNull Payment payment
    ) throws NoSuchAlgorithmException, InvalidKeyException {
        super(accessKey);
        this.payment = payment;
    }

    @Override
    public @NotNull String compile() {
        int paymentId = payment.getId();
        double cost = payment.getPurchaseCost();
        String customer = payment.getCustomer();

        String rawData = String.format(RAW_STRING_FORMAT, paymentId, cost, customer);
        return hashToHexString(rawData);
    }

    @Override
    public boolean compareWithReceived(@NotNull String receivedSignature) {
        Validate.notEmpty(receivedSignature, "receivedSignature");

        String compiledSignature = compile();
        return compiledSignature.equals(receivedSignature);
    }

}
