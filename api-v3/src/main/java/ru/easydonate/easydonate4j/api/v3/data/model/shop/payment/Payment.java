package ru.easydonate.easydonate4j.api.v3.data.model.shop.payment;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.DeliveryModeType;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.server.Server;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase.PurchasedProduct;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public interface Payment extends PrettyPrintable {

    int getId();

    int getShopId();

    @NotNull String getCustomer();

    @NotNull Optional<String> getEmail();

    int getStatusRaw();

    @NotNull PaymentStatus getStatus();

    double getPurchaseCost();

    double getEnrolledAmount();

    double getServiceComission();

    @NotNull String getPaymentSystemRaw();

    @NotNull PaymentSystem getPaymentSystem();

    @NotNull String getPaymentTypeRaw();

    @NotNull PaymentType getPaymentType();

    int getServerId();

    @NotNull String getDeliveryTypeRaw();

    @NotNull DeliveryModeType getDeliveryType();

    @NotNull Optional<String> getRedirectUrl();

    @NotNull Optional<String> getErrorMessage();

    int getHandleAttempts();

    boolean wasSent();

    @NotNull OptionalInt getRating();

    @NotNull List<SentCommand> getSentCommands();

    @NotNull List<PurchasedProduct> getProducts();

    @NotNull Server getServer();

    @NotNull LocalDateTime getCreatedAt();

    @NotNull LocalDateTime getUpdatedAt();

}
