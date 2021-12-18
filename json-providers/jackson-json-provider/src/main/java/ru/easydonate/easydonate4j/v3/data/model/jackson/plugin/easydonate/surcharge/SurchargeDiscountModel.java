package ru.easydonate.easydonate4j.v3.data.model.jackson.plugin.easydonate.surcharge;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscount;
import ru.easydonate.easydonate4j.v3.data.model.shop.AdditionalField;
import ru.easydonate.easydonate4j.v3.data.model.jackson.shop.AdditionalFieldModel;
import ru.easydonate.easydonate4j.v3.data.model.shop.ProductType;
import ru.easydonate.easydonate4j.v3.json.serialization.deserializer.jackson.NonNullListDeserializer;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Implementing(SurchargeDiscount.class)
public class SurchargeDiscountModel implements SurchargeDiscount {

    @JsonProperty("id")
    private int id;
    @JsonProperty("shop_id")
    private int shopId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String typeRaw;
    @JsonProperty("price")
    private double price;
    @JsonProperty("number")
    private int amount;

    @JsonProperty("description")
    private String description;
    @JsonProperty("old_price")
    private Double oldPrice;
    @JsonProperty("category_id")
    private Integer categoryId;
    @JsonProperty("image")
    private String iconImage;
    @JsonProperty("is_hidden")
    private boolean hidden;
    @JsonProperty("first_delete")
    private boolean oneTimePurchasable;

    @JsonProperty("commands")
    private List<String> commands;
    @JsonProperty("withdraw_commands")
    @JsonDeserialize(using = NonNullListDeserializer.class)
    private List<String> withdrawCommands;
    @JsonProperty("withdraw_commands_days")
    private Integer withdrawCommandsDelay;
    @JsonProperty("additional_fields")
    @JsonDeserialize(using = AdditionalFieldModel.ListDeserializer.class)
    private List<AdditionalField> additionalFields;
    @JsonProperty("sort_index")
    private int sortIndex;

    @JsonProperty("discount")
    private double discountAmount;
    @JsonProperty("target")
    private ExtraData currentMostExpensive;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;
    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;

    @JsonIgnore
    @Override
    public @NotNull ProductType getType() {
        return ProductType.getByKey(typeRaw);
    }

    @JsonIgnore
    @Override
    public @NotNull Optional<String> getDescription() {
        return Wrapper.wrapNullable(description);
    }

    @JsonIgnore
    @Override
    public @NotNull OptionalDouble getOldPrice() {
        return Wrapper.wrapNullableDouble(oldPrice);
    }

    @JsonIgnore
    @Override
    public @NotNull OptionalInt getCategoryId() {
        return Wrapper.wrapNullableInt(categoryId);
    }

    @JsonIgnore
    @Override
    public @NotNull OptionalInt getWithdrawCommandsDelay() {
        return Wrapper.wrapNullableInt(withdrawCommandsDelay);
    }

    @JsonIgnore
    @Override
    public @NotNull OptionalInt getCurrentMostExpensiveId() {
        if(currentMostExpensive != null)
            return OptionalInt.of(currentMostExpensive.getId());

        return OptionalInt.empty();
    }

    @Getter
    public static final class ExtraData {

        @JsonProperty("id")
        private int id;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ExtraData target = (ExtraData) o;
            return id == target.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public @NotNull String toString() {
            return "Target{" +
                    "id=" + id +
                    '}';
        }

    }

}
