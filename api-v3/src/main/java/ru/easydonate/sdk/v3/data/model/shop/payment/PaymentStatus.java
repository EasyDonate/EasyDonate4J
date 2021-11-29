package ru.easydonate.sdk.v3.data.model.shop.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PaymentStatus {

    UNPAID(0),
    WAITING(1),
    SUCCESS(2),
    UNKNOWN(-1);

    private final int code;

    public static @NotNull PaymentStatus getByCode(int code) {
        for(PaymentStatus paymentStatus : values())
            if(paymentStatus.getCode() == code)
                return paymentStatus;

        return PaymentStatus.UNKNOWN;
    }

}
