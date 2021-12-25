package ru.easydonate.easydonate4j.api.v3.data.model.shop;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The enum that represents all possible and actual product types.
 * @author soknight
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ProductType {

    /** Represents an in-game item. */
    ITEM("item"),

    /** Represents a privilege (permissions group). */
    PRIVILEGE("group"),

    /** Represents a virtual currency. */
    CURRENCY("currency"),

    /** Represents a roulette (one of items with custom chance). */
    CASE("case"),

    /** Represents a product without category. */
    OTHER("other"),

    /** Represents a product type that isn't known yet. */
    UNKNOWN("unknown");

    private final @NotNull String key;

    /**
     * Get the enum constant by the known product type key (can be null).
     * <br>
     * If the key is null/empty or relevant enum constant with this key will not be found then
     * this method will return {@link ProductType#UNKNOWN} constant as default.
     * @param key the product type key to find an enum constant.
     * @return The found product type enum constant or {@link ProductType#UNKNOWN} by default.
     */
    public static @NotNull ProductType getByKey(@Nullable String key) {
        if(key == null || key.isEmpty())
            return UNKNOWN;

        for(ProductType productType : values())
            if(productType.getKey().equalsIgnoreCase(key))
                return productType;

        return UNKNOWN;
    }

}
