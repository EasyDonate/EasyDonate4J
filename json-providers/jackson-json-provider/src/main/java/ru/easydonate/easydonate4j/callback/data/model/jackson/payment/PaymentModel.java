package ru.easydonate.easydonate4j.callback.data.model.jackson.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.data.model.payment.Payment;
import ru.easydonate.easydonate4j.callback.data.model.payment.PaymentType;
import ru.easydonate.easydonate4j.callback.data.model.purchase.PurchasedProduct;
import ru.easydonate.easydonate4j.callback.data.model.server.Server;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Getter
@Implementing(Payment.class)
public class PaymentModel implements Payment {

    @JsonProperty("payment_id")
    private int id;
    @JsonProperty("shop_id")
    private int shopId;
    @JsonProperty("customer")
    private String customer;
    @JsonProperty("email")
    private String email;

    @JsonProperty("cost")
    private double purchaseCost;
    @JsonProperty("income")
    private double serviceComission;

    @JsonProperty("payment_type")
    private String paymentTypeRaw;

    @JsonProperty("products")
    private List<PurchasedProduct> products;
    @JsonProperty("server")
    private Server server;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonProperty("signature")
    private String signature;

    @JsonIgnore
    @Override
    public @NotNull Optional<String> getEmail() {
        return Wrapper.wrapNullable(email);
    }

    @JsonIgnore
    @Override
    public @NotNull PaymentType getPaymentType() {
        return PaymentType.getByKey(paymentTypeRaw);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentModel that = (PaymentModel) o;
        return id == that.id &&
                shopId == that.shopId &&
                Double.compare(that.purchaseCost, purchaseCost) == 0 &&
                Double.compare(that.serviceComission, serviceComission) == 0 &&
                Objects.equals(customer, that.customer) &&
                Objects.equals(email, that.email) &&
                Objects.equals(paymentTypeRaw, that.paymentTypeRaw) &&
                Objects.equals(products, that.products) &&
                Objects.equals(server, that.server) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(updatedAt, that.updatedAt) &&
                Objects.equals(signature, that.signature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id, shopId, customer, email, purchaseCost, serviceComission,
                paymentTypeRaw, products, server, createdAt, updatedAt, signature
        );
    }

    @Override
    public @NotNull String toString() {
        return "PaymentModel{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", customer='" + customer + '\'' +
                ", email='" + email + '\'' +
                ", purchaseCost=" + purchaseCost +
                ", serviceComission=" + serviceComission +
                ", paymentTypeRaw='" + paymentTypeRaw + '\'' +
                ", products=" + products +
                ", server=" + server +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", signature='" + signature + '\'' +
                '}';
    }

}
