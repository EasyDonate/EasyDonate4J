package ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.pending;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.client.EasyDonateClient;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.Payment;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

/**
 * The interface that represents a pending payment.
 * @see EasyDonateClient#createPayment()
 * @author soknight
 */
public interface PendingPayment extends PrettyPrintable {

    /**
     * Get the customer URL to pay this purchase.
     * @return The payment URL.
     */
    @NotNull String getUrl();

    /**
     * Get the generated payment instance.
     * <br>
     * You can use that to get the payment ID and
     * check current payment status in the future.
     * @return The generated pending payment.
     */
    @NotNull Payment getPayment();

}
