package ru.soknight.easydonate.sdk.v1.payment;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AccessLevel;
import lombok.Setter;

/**
 * The object which provides any data for future prepared payment.
 * @author soknight
 */
@Setter(value = AccessLevel.PROTECTED)
public class PreparedPaymentData {

    private String customer;
    private int serverId;
    
    private final Map<Integer, Integer> products = new HashMap<>();
    
    /**
     * Get current <b>customer</b> of prepared payment.
     * @return The current payment customer.
     */
    public String getCustomer() {
        return customer;
    }
    
    /**
     * Get current <b>server ID</b> of prepared payment.
     * @return The current payment server ID.
     */
    public int getServerId() {
        return serverId;
    }
    
    /**
     * Get current <b>products</b> data of prepared payment.
     * @return The current payment products data.
     */
    public Map<Integer, Integer> getProducts() {
        return products;
    }
    
    /**
     * Get current products data of prepared payment as string.
     * <br>
     * This method is used by some other internal methods to format products map, but you can use it too.
     * <br>
     * A products map format is described on the <a href="https://api.easydonate.ru/methods/payment-create">platform documentation page</a>.
     * @return The current payment customer.
     */
    public String productsAsString() {
        if(products.isEmpty())
            return null;
        
        String joined = products.entrySet()
                .stream()
                .map(this::toString)
                .collect(Collectors.joining(", "));
        
        return "{" + joined + "}";
    }
    
    private String toString(Map.Entry<Integer, Integer> entry) {
        return "\"" + entry.getKey() + "\":" + entry.getValue();
    }
    
}
