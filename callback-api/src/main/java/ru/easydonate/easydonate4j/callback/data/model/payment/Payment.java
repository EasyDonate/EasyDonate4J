package ru.easydonate.easydonate4j.callback.data.model.payment;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.data.model.purchase.PurchasedProduct;
import ru.easydonate.easydonate4j.callback.data.model.server.Server;
import ru.easydonate.easydonate4j.callback.exception.SignatureGenerationException;
import ru.easydonate.easydonate4j.callback.signature.Signature;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface Payment extends PrettyPrintable {

    int getId();

    int getShopId();

    @NotNull String getCustomer();

    @NotNull Optional<String> getEmail();

    double getPurchaseCost();

    double getServiceComission();

    @NotNull String getPaymentTypeRaw();

    @NotNull PaymentType getPaymentType();

    @NotNull List<PurchasedProduct> getProducts();

    @NotNull Server getServer();

    @NotNull LocalDateTime getCreatedAt();

    @NotNull LocalDateTime getUpdatedAt();

    @NotNull String getSignature();

    default @NotNull Signature getSignatureFromData(@NotNull String accessKey) throws SignatureGenerationException {
        return Signature.paymentHmac(accessKey, this);
    }

}
