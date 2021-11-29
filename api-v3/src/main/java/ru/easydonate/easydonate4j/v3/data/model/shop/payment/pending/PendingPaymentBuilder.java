package ru.easydonate.easydonate4j.v3.data.model.shop.payment.pending;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.http.QueryParams;
import ru.easydonate.easydonate4j.util.Validate;
import ru.easydonate.easydonate4j.v3.client.EasyDonateClient;

import java.util.LinkedHashMap;
import java.util.Map;

public class PendingPaymentBuilder {

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

    public @NotNull EasyDonateClient getClient() {
        return client;
    }

    public @NotNull PendingPayment create() throws HttpRequestException, HttpResponseException {
        return client.createPayment(this);
    }

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

    public @NotNull PendingPaymentBuilder setCustomer(@NotNull String customer) {
        Validate.notNull(customer, "customer");
        this.customer = customer;
        return this;
    }

    public @NotNull PendingPaymentBuilder setServerId(int serverId) {
        Validate.isTrue(serverId > 0, "'serverId' must be greater than 0!");
        this.serverId = serverId;
        return this;
    }

    public @NotNull PendingPaymentBuilder addProduct(int productId) {
        return addProduct(productId, 1);
    }

    public @NotNull PendingPaymentBuilder addProduct(int productId, int amount) {
        Validate.isTrue(productId > 0, "'productId' must be greater than 0!");
        Validate.isTrue(amount > 0, "'amount' must be greater than 0!");
        this.products.compute(String.valueOf(productId), (key, value) -> value != null ? value + amount : amount);
        return this;
    }

    public @NotNull PendingPaymentBuilder setProducts(@NotNull Map<String, Integer> products) {
        Validate.notEmpty(products, "products");
        this.products.clear();
        this.products.putAll(products);
        return this;
    }

    public @NotNull PendingPaymentBuilder removeProduct(int productId) {
        Validate.isTrue(productId > 0, "'productId' must be greater than 0!");
        this.products.remove(String.valueOf(productId));
        return this;
    }

    public @NotNull PendingPaymentBuilder setEmail(@NotNull String email) {
        Validate.notNull(email, "email");
        this.email = email;
        return this;
    }

    public @NotNull PendingPaymentBuilder setCoupon(@NotNull String coupon) {
        Validate.notNull(coupon, "coupon");
        this.coupon = coupon;
        return this;
    }

    public @NotNull PendingPaymentBuilder setRedirectUrl(@NotNull String redirectUrl) {
        Validate.notNull(redirectUrl, "redirectUrl");
        this.redirectUrl = redirectUrl;
//        try {
//            this.redirectUrl = URLEncoder.encode(redirectUrl, StandardCharsets.UTF_8.name());
//        } catch (UnsupportedEncodingException ignored) {
//        }
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
