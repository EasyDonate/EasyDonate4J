package ru.soknight.easydonate.sdk.v2.data.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import ru.soknight.easydonate.sdk.v2.data.PrettyPrintable;
import ru.soknight.easydonate.sdk.v2.json.deserialize.DateDeserializer;
import ru.soknight.easydonate.sdk.v2.json.deserialize.DateSerializer;

/**
 * The object which represents a payment created via API.
 * @author soknight
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedPaymentModel implements PrettyPrintable {

    @JsonProperty("id")
    private int paymentId;
    @JsonProperty("customer")
    private String customer;
    @JsonProperty("email")
    private String email;

    @JsonProperty("cost")
    private double cost;
    @JsonProperty("enrolled")
    private double enrolledAmount;

    @JsonProperty("server_id")
    private int serverId;

    @JsonProperty("created_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;

    @JsonProperty("products")
    private List<PurchaseModel> products;
    @JsonProperty("server")
    private ServerModel server;

    @Override
    public int hashCode() {
        return Objects.hash(
                cost, createdAt, customer, email, enrolledAmount,
                paymentId, products, server, serverId, updatedAt
        );
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;

        CreatedPaymentModel other = (CreatedPaymentModel) obj;
        return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost) &&
                Objects.equals(createdAt, other.createdAt) &&
                Objects.equals(customer, other.customer) &&
                Objects.equals(email, other.email) &&
                Double.doubleToLongBits(enrolledAmount) == Double.doubleToLongBits(other.enrolledAmount) &&
                paymentId == other.paymentId &&
                Objects.equals(products, other.products) &&
                Objects.equals(server, other.server) &&
                serverId == other.serverId &&
                Objects.equals(updatedAt, other.updatedAt);
    }

    @Override
    public String toString() {
        return "Payment{"
                + "paymentId=" + paymentId
                + ", customer=" + customer
                + ", email=" + email
                + ", cost=" + cost
                + ", enrolledAmount=" + enrolledAmount
                + ", serverId=" + serverId
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + ", products=" + products
                + ", server=" + server
                + "}";
    }

}
