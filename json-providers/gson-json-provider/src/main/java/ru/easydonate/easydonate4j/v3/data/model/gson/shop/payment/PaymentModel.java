package ru.easydonate.easydonate4j.v3.data.model.gson.shop.payment;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;
import ru.easydonate.easydonate4j.v3.data.model.shop.DeliveryModeType;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.*;
import ru.easydonate.easydonate4j.v3.data.model.shop.purchase.PurchasedProduct;
import ru.easydonate.easydonate4j.v3.data.model.shop.server.Server;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

@Getter
@Implementing(Payment.class)
public class PaymentModel implements Payment {

    @SerializedName("id")
    private int id;
    @SerializedName("shop_id")
    private int shopId;
    @SerializedName("customer")
    private String customer;
    @SerializedName("email")
    private String email;
    @SerializedName("status")
    private int statusRaw;

    @SerializedName("cost")
    private double purchaseCost;
    @SerializedName("enrolled")
    private double enrolledAmount;
    @SerializedName("income")
    private double serviceComission;

    @SerializedName("payment_system")
    private String paymentSystemRaw;
    @SerializedName("payment_type")
    private String paymentTypeRaw;

    @SerializedName("server_id")
    private int serverId;
    @SerializedName("delivery_type")
    private String deliveryTypeRaw;
    @SerializedName("success_url")
    private String redirectUrl;
    @SerializedName("error")
    private String errorMessage;

    @SerializedName("attempts")
    private int handleAttempts;
    @SerializedName("was_sent")
    private boolean wasSent;
    @SerializedName("rating")
    private Integer rating;

    @SerializedName("sent_commands")
    private List<SentCommand> sentCommands;
    @SerializedName("products")
    private List<PurchasedProduct> products;
    @SerializedName("server")
    private Server server;

    @SerializedName("created_at")
    private LocalDateTime createdAt;
    @SerializedName("updated_at")
    private LocalDateTime updatedAt;

    @Override
    public @NotNull Optional<String> getEmail() {
        return Wrapper.wrapNullable(email);
    }

    @Override
    public @NotNull PaymentStatus getStatus() {
        return PaymentStatus.getByCode(statusRaw);
    }

    @Override
    public @NotNull PaymentSystem getPaymentSystem() {
        return PaymentSystem.getByKey(paymentSystemRaw);
    }

    @Override
    public @NotNull PaymentType getPaymentType() {
        return PaymentType.getByKey(paymentTypeRaw);
    }

    @Override
    public @NotNull DeliveryModeType getDeliveryType() {
        return DeliveryModeType.getByKey(deliveryTypeRaw);
    }

    @Override
    public @NotNull Optional<String> getRedirectUrl() {
        return Wrapper.wrapNullable(redirectUrl);
    }

    @Override
    public boolean wasSent() {
        return wasSent;
    }

    @Override
    public @NotNull OptionalInt getRating() {
        return Wrapper.wrapNullableInt(rating);
    }

    @Override
    public @NotNull Optional<String> getErrorMessage() {
        return Wrapper.wrapNullable(errorMessage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentModel that = (PaymentModel) o;
        return id == that.id &&
                shopId == that.shopId &&
                statusRaw == that.statusRaw &&
                Double.compare(that.purchaseCost, purchaseCost) == 0 &&
                Double.compare(that.enrolledAmount, enrolledAmount) == 0 &&
                Double.compare(that.serviceComission, serviceComission) == 0 &&
                serverId == that.serverId &&
                handleAttempts == that.handleAttempts &&
                wasSent == that.wasSent &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(email, that.email) &&
                Objects.equals(paymentSystemRaw, that.paymentSystemRaw) &&
                Objects.equals(paymentTypeRaw, that.paymentTypeRaw) &&
                Objects.equals(deliveryTypeRaw, that.deliveryTypeRaw) &&
                Objects.equals(redirectUrl, that.redirectUrl) &&
                Objects.equals(errorMessage, that.errorMessage) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(sentCommands, that.sentCommands) &&
                Objects.equals(products, that.products) &&
                Objects.equals(server, that.server) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, shopId, customer, email, statusRaw, purchaseCost, enrolledAmount, serviceComission,
                paymentSystemRaw, paymentTypeRaw, serverId, deliveryTypeRaw, redirectUrl, errorMessage,
                handleAttempts, wasSent, rating, sentCommands, products, server, createdAt, updatedAt
        );
    }

    @Override
    public @NotNull String toString() {
        return "PaymentModel{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", customer='" + customer + '\'' +
                ", email='" + email + '\'' +
                ", statusRaw=" + statusRaw +
                ", purchaseCost=" + purchaseCost +
                ", enrolledAmount=" + enrolledAmount +
                ", serviceComission=" + serviceComission +
                ", paymentSystemRaw='" + paymentSystemRaw + '\'' +
                ", paymentTypeRaw='" + paymentTypeRaw + '\'' +
                ", serverId=" + serverId +
                ", deliveryTypeRaw='" + deliveryTypeRaw + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", handleAttempts=" + handleAttempts +
                ", wasSent=" + wasSent +
                ", rating=" + rating +
                ", sentCommands=" + sentCommands +
                ", products=" + products +
                ", server=" + server +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
