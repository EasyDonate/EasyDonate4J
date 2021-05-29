package ru.soknight.easydonate.sdk.v1.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import ru.soknight.easydonate.sdk.v1.data.PrettyPrintable;
import ru.soknight.easydonate.sdk.v1.json.deserialize.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.OptionalInt;

/**
 * The object which represents any shop product.
 * @author soknight
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true, value = { "pivot" })
public class ProductModel implements PrettyPrintable {

    @JsonProperty("id")
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
    @JsonProperty("sort_index")
    private int sortIndex;
    
    @JsonProperty("created_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializer.class)
    private LocalDateTime updatedAt;
    
    @JsonProperty("servers")
    private List<ServerModel> servers;

    @Override
    public int hashCode() {
        return Objects.hash(
                addtitionalFields, amount, categoryId, createdAt, deleteAfterFirstPurchase, description,
                giveCommands, image, name, oldPrice, price, productId, servers, shopId, sortIndex,
                type, updatedAt, withdrawCommands, withdrawCommandsDelay
        );
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        
        ProductModel other = (ProductModel) obj;
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
                Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price) &&
                productId == other.productId &&
                Objects.equals(servers, other.servers) &&
                shopId == other.shopId &&
                sortIndex == other.sortIndex &&
                Objects.equals(type, other.type) &&
                Objects.equals(updatedAt, other.updatedAt) &&
                Objects.equals(withdrawCommands, other.withdrawCommands) &&
                Objects.equals(withdrawCommandsDelay, other.withdrawCommandsDelay);
    }

    

    @Override
    public String toString() {
        return "Product{"
                + "productId=" + productId
                + ", name='" + name + "'"
                + ", type=" + type
                + ", amount=" + amount
                + ", description='" + description + "'"
                + ", giveCommands=" + giveCommands
                + ", withdrawCommands=" + withdrawCommands
                + ", withdrawCommandsDelay=" + withdrawCommandsDelay
                + ", addtitionalFields=" + addtitionalFields
                + ", price=" + price
                + ", oldPrice=" + oldPrice
                + ", image=" + image
                + ", deleteAfterFirstPurchase=" + deleteAfterFirstPurchase
                + ", shopId=" + shopId
                + ", sortIndex=" + sortIndex
                + ", createdAt=" + createdAt
                + ", updatedAt=" + updatedAt
                + ", servers=" + servers
                + "}";
    }
    
}
