package ru.easydonate.easydonate4j.api.v3.data.model.shop.payment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * The enum that represents all possible and actual payment statuses.
 * @author soknight
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum PaymentStatus {

    /** Represents the payment status when the payment isn't paid yet.*/
    UNPAID(0),

    /** Represents the payment status when the platform has waiting for the payment completion.*/
    WAITING(1),

    /** Represents the payment status when the payment is paid and fully completed.*/
    SUCCESS(2),

    /** Represents the payment status that isn't known yet.*/
    UNKNOWN(-1);

    private final int code;

    /**
     * Get the enum constant by the known payment status code.
     * <br>
     * If a relevant enum constant with this code will not be found then
     * this method will return {@link PaymentStatus#UNKNOWN} constant as default.
     * @param code the payment status code to find an enum constant.
     * @return The found payment system enum constant or {@link PaymentStatus#UNKNOWN} by default.
     */
    public static @NotNull PaymentStatus getByCode(int code) {
        for(PaymentStatus paymentStatus : values())
            if(paymentStatus.getCode() == code)
                return paymentStatus;

        return PaymentStatus.UNKNOWN;
    }

}
