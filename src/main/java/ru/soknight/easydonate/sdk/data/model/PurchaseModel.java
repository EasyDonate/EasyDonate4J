package ru.soknight.easydonate.sdk.data.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import ru.soknight.easydonate.sdk.data.PrettyPrintable;
import ru.soknight.easydonate.sdk.json.deserialize.AdditionalFieldListDeserializer;
import ru.soknight.easydonate.sdk.json.deserialize.DateDeserializer;
import ru.soknight.easydonate.sdk.json.deserialize.DateSerializer;
import ru.soknight.easydonate.sdk.json.deserialize.OptionalDoubleDeserializer;
import ru.soknight.easydonate.sdk.json.deserialize.OptionalDoubleSerializer;
import ru.soknight.easydonate.sdk.json.deserialize.OptionalIntDeserializer;
import ru.soknight.easydonate.sdk.json.deserialize.OptionalIntSerializer;

/**
 * The object which represents any purchased products.
 * @author soknight
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseModel implements PrettyPrintable {

    @JsonProperty("id")
    private int purchaseId;
    @JsonProperty("product_id")
    private int productId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("number")
    private int amount;
    @JsonProperty("description")
    private String description;
    
    @JsonProperty("commands")
    private List<String> giveCommands;
    @JsonProperty("withdraw_commands")
    private List<String> withdrawCommands;
    @JsonProperty("withdraw_commands_days")
    @JsonSerialize(using = OptionalIntSerializer.class)
    @JsonDeserialize(using = OptionalIntDeserializer.class)
    private OptionalInt withdrawCommandsDelay;
    
    @JsonProperty("additional_fields")
    @JsonDeserialize(using = AdditionalFieldListDeserializer.class)
    private List<AdditionalField> addtitionalFields;
    
    @JsonProperty("payment_id")
    private int paymentId;
    @JsonProperty("amount")
    private int purchasedAmount;
    
    @JsonProperty("price")
    private double price;
    @JsonProperty("old_price")
    @JsonSerialize(using = OptionalDoubleSerializer.class)
    @JsonDeserialize(using = OptionalDoubleDeserializer.class)
    private OptionalDouble oldPrice;

    @JsonProperty("image")
    private String image;
    @JsonProperty("first_delete")
    private boolean deleteAfterFirstPurchase;
    
    @JsonProperty("shop_id")
    private int shopId;
    @JsonProperty("category_id")
    @JsonSerialize(using = OptionalIntSerializer.class)
    @JsonDeserialize(using = OptionalIntDeserializer.class)
    private OptionalInt categoryId;
    
    @JsonProperty("created_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;
    
    @Override
    public int hashCode() {
        return Objects.hash(
                addtitionalFields, amount, categoryId, createdAt, deleteAfterFirstPurchase, description,
                giveCommands, image, name, oldPrice, paymentId, price, productId, purchaseId, purchasedAmount,
                shopId, type, updatedAt, withdrawCommands, withdrawCommandsDelay
        );
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        
        PurchaseModel other = (PurchaseModel) obj;
        return Objects.equals(addtitionalFields, other.addtitionalFields) &&
                amount == other.amount &&
                Objects.equals(categoryId, other.categoryId) &&
                Objects.equals(createdAt, other.createdAt) &&
                deleteAfterFirstPurchase == other.deleteAfterFirstPurchase &&
                Objects.equals(description, other.description) &&
                Objects.equals(giveCommands, other.giveCommands) &&
                Objects.equals(image, other.image) &&
                Objects.equals(name, other.name) &&
                Objects.equals(oldPrice, other.oldPrice) &&
                paymentId == other.paymentId &&
                Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) &&
                productId == other.productId &&
                purchaseId == other.purchaseId &&
                purchasedAmount == other.purchasedAmount &&
                shopId == other.shopId &&
                Objects.equals(type, other.type) &&
                Objects.equals(updatedAt, other.updatedAt) &&
                Objects.equals(withdrawCommands, other.withdrawCommands) &&
                Objects.equals(withdrawCommandsDelay, other.withdrawCommandsDelay);
    }

    @Override
    public String toString() {
        return "Purchase{"
                + "purchaseId=" + purchaseId
                + ", productId=" + productId
                + ", name='" + name + "'"
                + ", type=" + type
                + ", amount=" + amount
                + ", description='" + description + "'"
                + ", giveCommands=" + giveCommands
                + ", withdrawCommands=" + withdrawCommands
                + ", withdrawCommandsDelay=" + withdrawCommandsDelay
                + ", addtitionalFields=" + addtitionalFields
                + ", paymentId=" + paymentId
                + ", purchasedAmount=" + purchasedAmount
                + ", price=" + price
                + ", oldPrice=" + oldPrice
                + ", image=" + image
                + ", deleteAfterFirstPurchase=" + deleteAfterFirstPurchase
                + ", shopId=" + shopId
                + ", categoryId=" + categoryId
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + "}";
    }
    
}
