package ru.easydonate.sdk.v3.data.model.gson.shop.payment.pending;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.shop.payment.Payment;
import ru.easydonate.sdk.v3.data.model.shop.payment.pending.PendingPayment;

import java.util.Objects;

@Getter
@Implementing(PendingPayment.class)
public class PendingPaymentModel implements PendingPayment {

    @SerializedName("url")
    private String url;
    @SerializedName("payment")
    private Payment payment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PendingPaymentModel that = (PendingPaymentModel) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(payment, that.payment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, payment);
    }

    @Override
    public @NotNull String toString() {
        return "PendingPaymentModel{" +
                "url='" + url + '\'' +
                ", payment=" + payment +
                '}';
    }

}
