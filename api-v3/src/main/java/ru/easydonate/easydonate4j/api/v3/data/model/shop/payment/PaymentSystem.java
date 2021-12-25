package ru.easydonate.easydonate4j.api.v3.data.model.shop.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * The enum that represents all possible and actual payment systems.
 * @author soknight
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PaymentSystem {

    /** Represents the InterCassa payment system. */
    INTER_KASSA("Interkassa"),

    /** Represents the PayMaster payment system. */
    PAY_MASTER("PayMaster"),

    /** Represents the QiWi payment system. */
    QIWI("Qiwi"),

    /** Represents the payment system stub for any test payments. */
    TEST_MODE("test"),

    /** Represents a payment system that isn't known yet. */
    UNKNOWN("unknown");

    private final String key;

    /**
     * Get the enum constant by the known payment system key (can be null).
     * <br>
     * If the key is null/empty or relevant enum constant with this key will not be found then
     * this method will return {@link PaymentSystem#UNKNOWN} constant as default.
     * @param key the payment system key to find an enum constant.
     * @return The found payment system enum constant or {@link PaymentSystem#UNKNOWN} by default.
     */
    public static @NotNull PaymentSystem getByKey(@NotNull String key) {
        if(key == null)
            return UNKNOWN;

        for(PaymentSystem paymentSystem : values())
            if(paymentSystem.getKey().equalsIgnoreCase(key))
                return paymentSystem;

        return UNKNOWN;
    }

}
