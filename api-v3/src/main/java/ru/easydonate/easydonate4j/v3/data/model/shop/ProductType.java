package ru.easydonate.easydonate4j.v3.data.model.shop;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ProductType {

    ITEM("item"),
    PRIVILEGE("group"),
    CURRENCY("currency"),
    CASE("case"),
    OTHER("other"),
    UNKNOWN("unknown");

    private final @NotNull String key;

    public static @NotNull ProductType getByKey(@Nullable String key) {
        if(key == null || key.isEmpty())
            return UNKNOWN;

        for(ProductType productType : values())
            if(productType.getKey().equalsIgnoreCase(key))
                return productType;

        return UNKNOWN;
    }

}
