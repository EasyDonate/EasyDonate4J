package ru.soknight.easydonate.sdk.data.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import ru.soknight.easydonate.sdk.data.PrettyPrintable;
import ru.soknight.easydonate.sdk.json.deserialize.DateDeserializer;
import ru.soknight.easydonate.sdk.json.deserialize.DateSerializer;
import ru.soknight.easydonate.sdk.json.deserialize.SilentListDeserializer;

/**
 * The object which represents pending or completed payment.
 * @author soknight
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentModel implements PrettyPrintable {

    @JsonProperty("id")
    private int paymentId;
    @JsonProperty("customer")
    private String customer;
    @JsonProperty("email")
    private String email;
    @JsonProperty("status")
    private int status;

    @JsonProperty("cost")
    private double cost;
    @JsonProperty("enrolled")
    private double enrolledAmount;
    @JsonProperty("payment_system")
    private String paymentSystem;
    @JsonProperty("payment_type")
    private String paymentType;
    
    @JsonProperty("shop_id")
    private int shopId;
    @JsonProperty("server_id")
    private int serverId;
    @JsonProperty("error")
    private String error;
    
    @JsonProperty("created_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;
    
    @JsonProperty("sent_commands")
    @JsonDeserialize(using = SilentListDeserializer.class)
    private List<SentCommand> sentCommands;
    @JsonProperty("products")
    private List<PurchaseModel> products;
    @JsonProperty("server")
    private ServerModel server;
    
    @Override
    public int hashCode() {
        return Objects.hash(
                createdAt, customer, email, enrolledAmount, error, paymentId, paymentSystem,
                paymentType, products, sentCommands, server, serverId, shopId, status, updatedAt
        );
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        
        PaymentModel other = (PaymentModel) obj;
        return Objects.equals(createdAt, other.createdAt) &&
                Objects.equals(customer, other.customer) &&
                Objects.equals(email, other.email) &&
                Double.doubleToLongBits(enrolledAmount) == Double.doubleToLongBits(other.enrolledAmount) &&
                Objects.equals(error, other.error) &&
                paymentId == other.paymentId &&
                Objects.equals(paymentSystem, other.paymentSystem) &&
                Objects.equals(paymentType, other.paymentType) &&
                Objects.equals(products, other.products) &&
                Objects.equals(sentCommands, other.sentCommands) &&
                Objects.equals(server, other.server) &&
                serverId == other.serverId &&
                shopId == other.shopId &&
                status == other.status &&
                Objects.equals(updatedAt, other.updatedAt);
    }

    @Override
    public String toString() {
        return "Payment{"
                + "paymentId=" + paymentId
                + ", customer=" + customer
                + ", email=" + email
                + ", status=" + status
                + ", enrolledAmount=" + enrolledAmount
                + ", paymentSystem=" + paymentSystem
                + ", paymentType=" + paymentType
                + ", shopId=" + shopId
                + ", serverId=" + serverId
                + ", error=" + error
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + ", sentCommands=" + sentCommands
                + ", products=" + products
                + ", server=" + server
                + "}";
    }
    
}
