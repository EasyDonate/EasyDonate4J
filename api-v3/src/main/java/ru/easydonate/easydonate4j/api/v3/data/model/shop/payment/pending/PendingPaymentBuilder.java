package ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.pending;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.http.QueryParams;
import ru.easydonate.easydonate4j.util.Validate;
import ru.easydonate.easydonate4j.api.v3.client.EasyDonateClient;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The pending payment builder that can be used to customize the generating payment.
 * @see EasyDonateClient#createPayment()
 * @author soknight
 */
public final class PendingPaymentBuilder {

    private final EasyDonateClient client;
    private final Map<String, Integer> products;

    private String customer;
    private Integer serverId;
    private String email;
    private String coupon;
    private String redirectUrl;

    public PendingPaymentBuilder(@NotNull EasyDonateClient client) {
        Validate.notNull(client, "client");
        this.client = client;
        this.products = new LinkedHashMap<>();
    }

    /**
     * Get the owning API client instance.
     * @return The API client instance.
     */
    public @NotNull EasyDonateClient getClient() {
        return client;
    }

    /**
     * Create a payment with current configuration.
     * @return The generated pending payment instance.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see PendingPayment
     * @see EasyDonateClient#createPayment(PendingPaymentBuilder)
     */
    public @NotNull PendingPayment create() throws HttpRequestException, HttpResponseException {
        return client.createPayment(this);
    }

    /**
     * Convert current payment configuration to the query params.
     * @return The created query params instance.
     */
    public @NotNull QueryParams toQueryParams() {
        QueryParams queryParams = new QueryParams();

        try {
            if(customer != null)        queryParams.set("customer", customer);
            if(serverId != null)        queryParams.set("server_id", serverId);
            if(products != null)        queryParams.set("products", client.getJsonSerialization().serialize(products));
            if(email != null)           queryParams.set("email", email);
            if(coupon != null)          queryParams.set("coupon", coupon);
            if(redirectUrl != null)     queryParams.set("success_url", redirectUrl);
        } catch (JsonSerializationException ignored) {
        }

        return queryParams;
    }

    /**
     * Set a new customer for this payment.
     * @param customer a new customer.
     * @return The builder instance for method chaining continuation.
     */
    public @NotNull PendingPaymentBuilder setCustomer(@NotNull String customer) {
        Validate.notNull(customer, "customer");
        this.customer = customer;
        return this;
    }

    /**
     * Set a new server ID for this payment.
     * @param serverId a new server ID.
     * @return The builder instance for method chaining continuation.
     */
    public @NotNull PendingPaymentBuilder setServerId(int serverId) {
        Validate.isTrue(serverId > 0, "'serverId' must be greater than 0!");
        this.serverId = serverId;
        return this;
    }

    /**
     * Add a new product x1 for this payment.
     * @param productId the ID of an adding product.
     * @return The builder instance for method chaining continuation.
     */
    public @NotNull PendingPaymentBuilder addProduct(int productId) {
        return addProduct(productId, 1);
    }

    /**
     * Add a new product with custom amount for this payment.
     * @param productId the ID of an adding product.
     * @param amount an amount of this product.
     * @return The builder instance for method chaining continuation.
     */
    public @NotNull PendingPaymentBuilder addProduct(int productId, int amount) {
        Validate.isTrue(productId > 0, "'productId' must be greater than 0!");
        Validate.isTrue(amount > 0, "'amount' must be greater than 0!");
        this.products.compute(String.valueOf(productId), (key, value) -> value != null ? value + amount : amount);
        return this;
    }

    /**
     * Set a new products shopcart for this payment.
     * @param products a new products shopcart.
     * @return The builder instance for method chaining continuation.
     */
    public @NotNull PendingPaymentBuilder setProducts(@NotNull Map<String, Integer> products) {
        Validate.notEmpty(products, "products");
        this.products.clear();
        this.products.putAll(products);
        return this;
    }

    /**
     * Remove an added product from the shopcart.
     * @param productId the ID of added product.
     * @return The builder instance for method chaining continuation.
     */
    public @NotNull PendingPaymentBuilder removeProduct(int productId) {
        Validate.isTrue(productId > 0, "'productId' must be greater than 0!");
        this.products.remove(String.valueOf(productId));
        return this;
    }

    /**
     * Set a new customer email for this payment.
     * @param email a new customer email.
     * @return The builder instance for method chaining continuation.
     */
    public @NotNull PendingPaymentBuilder setEmail(@NotNull String email) {
        Validate.notNull(email, "email");
        this.email = email;
        return this;
    }

    /**
     * Set a new coupon used for this payment.
     * @param coupon a new coupon code.
     * @return The builder instance for method chaining continuation.
     */
    public @NotNull PendingPaymentBuilder setCoupon(@NotNull String coupon) {
        Validate.notNull(coupon, "coupon");
        this.coupon = coupon;
        return this;
    }

    /**
     * Set a new redirect URL for this payment.
     * @param redirectUrl a new redirect URL.
     * @return The builder instance for method chaining continuation.
     */
    public @NotNull PendingPaymentBuilder setRedirectUrl(@NotNull String redirectUrl) {
        Validate.notNull(redirectUrl, "redirectUrl");
        this.redirectUrl = redirectUrl;
        return this;
    }

    @Override
    public @NotNull String toString() {
        return "PendingPaymentBuilder{" +
                ", customer='" + customer + '\'' +
                ", serverId=" + serverId +
                ", products=" + products +
                ", email='" + email + '\'' +
                ", coupon='" + coupon + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                '}';
    }

}
