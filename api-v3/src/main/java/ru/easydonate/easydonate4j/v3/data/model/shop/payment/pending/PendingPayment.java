package ru.easydonate.easydonate4j.v3.data.model.shop.payment.pending;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.Payment;

public interface PendingPayment extends PrettyPrintable {

    @NotNull String getUrl();

    @NotNull Payment getPayment();

}
