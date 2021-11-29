package ru.easydonate.easydonate4j.v3.data.model.jackson.shop.payment.pending;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.Payment;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.pending.PendingPayment;

import java.util.Objects;

@Getter
@Implementing(PendingPayment.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PendingPaymentModel implements PendingPayment {

    @JsonProperty("url")
    private String url;
    @JsonProperty("payment")
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
