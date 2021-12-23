package ru.easydonate.easydonate4j.api.v3.data.model.shop.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PaymentType {

    MOBILE_COMMERCE("mc"),
    QIWI("qiwi"),
    CREDIT_CARD("card"),
    YOOMONEY("yoomoney"),
    WEBMONEY("webmoney"),
    TEST_MODE("test"),
    UNKNOWN("unknown");

    private final String key;

    public static @NotNull PaymentType getByKey(@NotNull String key) {
        if(key == null)
            return UNKNOWN;

        for(PaymentType paymentType : values())
            if(paymentType.getKey().equalsIgnoreCase(key))
                return paymentType;

        return UNKNOWN;
    }

}
