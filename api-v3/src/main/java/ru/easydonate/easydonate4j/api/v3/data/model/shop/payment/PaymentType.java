package ru.easydonate.easydonate4j.api.v3.data.model.shop.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * The enum that represents all possible and actual payment types.
 * @author soknight 
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PaymentType {

    /** Represents the Mobile Commerce (mobile operators). */
    MOBILE_COMMERCE("mc"),

    /** Represents the QiWi payment type. */
    QIWI("qiwi"),

    /** Represents the credit card payment type. */
    CREDIT_CARD("card"),

    /** Represents the YooMoney payment type. */
    YOOMONEY("yoomoney"),

    /** Represents the WebMoney payment type. */
    WEBMONEY("webmoney"),

    /** Represents the payment type stub for any test payments. */
    TEST_MODE("test"),

    /** Represents a payment type that isn't known yet. */
    UNKNOWN("unknown");

    private final String key;

    /**
     * Get the enum constant by the known payment type key (can be null).
     * <br>
     * If the key is null/empty or relevant enum constant with this key will not be found then
     * this method will return {@link PaymentType#UNKNOWN} constant as default.
     * @param key the payment type key to find an enum constant.
     * @return The found payment type enum constant or {@link PaymentType#UNKNOWN} by default.
     */
    public static @NotNull PaymentType getByKey(@NotNull String key) {
        if(key == null)
            return UNKNOWN;

        for(PaymentType paymentType : values())
            if(paymentType.getKey().equalsIgnoreCase(key))
                return paymentType;

        return UNKNOWN;
    }

}
