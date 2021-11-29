package ru.easydonate.sdk.v3.data.model.gson.plugin.easydonate.surcharge;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.util.Wrapper;
import ru.easydonate.sdk.v3.data.model.gson.shop.AdditionalFieldModel;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.surcharge.SurchargeDiscount;
import ru.easydonate.sdk.v3.data.model.shop.AdditionalField;
import ru.easydonate.sdk.v3.data.model.shop.ProductType;
import ru.easydonate.sdk.v3.json.serialization.deserializer.gson.NonNullListDeserializer;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Implementing(SurchargeDiscount.class)
public class SurchargeDiscountModel implements SurchargeDiscount {

    @SerializedName("id")
    private int id;
    @SerializedName("shop_id")
    private int shopId;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String typeRaw;
    @SerializedName("price")
    private double price;
    @SerializedName("number")
    private int amount;

    @SerializedName("description")
    private String description;
    @SerializedName("old_price")
    private Double oldPrice;
    @SerializedName("category_id")
    private Integer categoryId;
    @SerializedName("image")
    private String iconImage;
    @SerializedName("is_hidden")
    private boolean hidden;
    @SerializedName("first_delete")
    private boolean oneTimePurchasable;

    @SerializedName("commands")
    private List<String> commands;
    @SerializedName("withdraw_commands")
    @JsonAdapter(NonNullListDeserializer.class)
    private List<String> withdrawCommands;
    @SerializedName("withdraw_commands_days")
    private Integer withdrawCommandsDelay;
    @SerializedName("additional_fields")
    @JsonAdapter(AdditionalFieldModel.ListDeserializer.class)
    private List<AdditionalField> additionalFields;
    @SerializedName("sort_index")
    private int sortIndex;

    @SerializedName("discount")
    private double discountAmount;
    @SerializedName("target")
    private ExtraData currentMostExpensive;

    @SerializedName("created_at")
    private LocalDateTime createdAt;
    @SerializedName("updated_at")
    private LocalDateTime updatedAt;

    @Override
    public @NotNull ProductType getType() {
        return ProductType.getByKey(typeRaw);
    }

    @Override
    public @NotNull Optional<String> getDescription() {
        return Wrapper.wrapNullable(description);
    }

    @Override
    public @NotNull OptionalDouble getOldPrice() {
        return Wrapper.wrapNullableDouble(oldPrice);
    }

    @Override
    public @NotNull OptionalInt getCategoryId() {
        return Wrapper.wrapNullableInt(categoryId);
    }

    @Override
    public @NotNull OptionalInt getWithdrawCommandsDelay() {
        return Wrapper.wrapNullableInt(withdrawCommandsDelay);
    }

    @Override
    public @NotNull OptionalInt getCurrentMostExpensiveId() {
        if(currentMostExpensive != null)
            return OptionalInt.of(currentMostExpensive.getId());

        return OptionalInt.empty();
    }

    @Getter
    public static final class ExtraData {

        @SerializedName("id")
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
