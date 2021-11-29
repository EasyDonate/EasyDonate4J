package ru.easydonate.sdk.v3.data.model.shop.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PaymentSystem {

    INTER_KASSA("Interkassa"),
    PAY_MASTER("PayMaster"),
    QIWI("Qiwi"),
    TEST_MODE("test"),
    UNKNOWN("unknown");

    private final String key;

    public static @NotNull PaymentSystem getByKey(@NotNull String key) {
        if(key == null)
            return UNKNOWN;

        for(PaymentSystem paymentSystem : values())
            if(paymentSystem.getKey().equalsIgnoreCase(key))
                return paymentSystem;

        return UNKNOWN;
    }

}
