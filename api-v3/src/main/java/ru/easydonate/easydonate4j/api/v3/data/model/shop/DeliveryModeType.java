package ru.easydonate.easydonate4j.api.v3.data.model.shop;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * The enum that represents all possible and actual delivery modes.
 * @author soknight
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DeliveryModeType {

    /**
     * Represents the RCON protocol based delivery mode.
     */
    RCON("rcon"),

    /**
     * Represents the Plugin based delivery mode.
     */
    PLUGIN("plugin"),

    /**
     * Represents an unknown delivery mode, not known yet.
     */
    UNKNOWN("unknown");

    private final @NotNull String key;

    /**
     * Get the enum constant by the known delivery mode key (can be null).
     * <br>
     * If the key is null/empty or relevant enum constant with this key will not be found then
     * this method will return {@link DeliveryModeType#UNKNOWN} constant as default.
     * @param key the delivery mode key to find an enum constant.
     * @return The found delivery mode enum constant or {@link DeliveryModeType#UNKNOWN} by default.
     */
    public static @NotNull DeliveryModeType getByKey(@Nullable String key) {
        if(key == null || key.isEmpty())
            return UNKNOWN;

        for(DeliveryModeType deliveryType : values())
            if(deliveryType.getKey().equalsIgnoreCase(key))
                return deliveryType;

        return UNKNOWN;
    }

}
