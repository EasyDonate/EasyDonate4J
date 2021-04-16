package ru.soknight.easydonate.sdk.payment;

import java.util.Map;

import lombok.AllArgsConstructor;

/**
 * The easy-to-use chain-based {@link PreparedPaymentData} creator.
 * @author soknight
 */
@AllArgsConstructor(staticName = "newCreator")
public class PaymentCreator {
    
    private final PreparedPaymentData paymentData = new PreparedPaymentData();
    
    /**
     * Finish payment data customization and get resulting object.
     * @return The customized payment data instance.
     */
    public PreparedPaymentData create() {
        return paymentData;
    }
    
    /**
     * Get current <b>customer</b> of future payment.
     * @return The current payment customer.
     */
    public String getCustomer() {
        return paymentData.getCustomer();
    }
    
    /**
     * Get current <b>server ID</b> of future payment.
     * @return The current payment server ID.
     */
    public int getServerId() {
        return paymentData.getServerId();
    }
    
    /**
     * Get current <b>products</b> data of future payment.
     * @return The current payment products data.
     */
    public Map<Integer, Integer> getProducts() {
        return paymentData.getProducts();
    }
    
    /**
     * Set new <b>customer</b> for future payment.
     * @param customer - new payment customer.
     * @return The current creator instance for method-chaining.
     */
    public PaymentCreator setCustomer(String customer) {
        paymentData.setCustomer(customer);
        return this;
    }

    /**
     * Set new <b>server ID</b> for future payment.
     * @param serverId - new payment server ID.
     * @return The current creator instance for method-chaining.
     */
    public PaymentCreator setServerId(int serverId) {
        paymentData.setServerId(serverId);
        return this;
    }
    
    /**
     * Add new product for future payment in the amount of 1 piece.
     * @param productId - the ID of product which you want to add to.
     * @return The current creator instance for method-chaining.
     */
    public PaymentCreator addProduct(int productId) {
        return addProduct(productId, 1);
    }
    
    /**
     * Add new product for future payment in the specified amount.
     * @param productId - the ID of product which you want to add to.
     * @param amount - the amount of products to add.
     * @return The current creator instance for method-chaining.
     */
    public PaymentCreator addProduct(int productId, int amount) {
        paymentData.getProducts().put(productId, amount);
        return this;
    }
    
    /**
     * Remove added product from future payment.
     * @param productId - the ID of payment which you want to remove.
     * @return The current creator instance for method-chaining.
     */
    public PaymentCreator removeProduct(int productId) {
        paymentData.getProducts().remove(productId);
        return this;
    }
    
}
