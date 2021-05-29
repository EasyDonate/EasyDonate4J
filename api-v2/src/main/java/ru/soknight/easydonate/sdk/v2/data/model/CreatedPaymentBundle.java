package ru.soknight.easydonate.sdk.v2.data.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import ru.soknight.easydonate.sdk.v2.data.PrettyPrintable;

/**
 * The object which represents payment creation API response model and used to store URL and payment object.
 * @author soknight
 */
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatedPaymentBundle implements PrettyPrintable {

    @JsonProperty("url")
    private String url;
    @JsonProperty("payment")
    private CreatedPaymentModel payment;
    
    @Override
    public int hashCode() {
        return Objects.hash(payment, url);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || getClass() != obj.getClass())
            return false;
        
        CreatedPaymentBundle other = (CreatedPaymentBundle) obj;
        return Objects.equals(payment, other.payment) &&
                Objects.equals(url, other.url);
    }

    @Override
    public String toString() {
        return "CreatedPayment{"
                + "url=" + url
                + ", payment=" + payment
                + "}";
    }
    
}
