package ru.easydonate.easydonate4j.api.v3.client;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.Constants;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginManager;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.ActivityFlag;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.Shop;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.coupon.Coupon;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.coupon.CouponsList;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.mass.sale.MassSale;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.mass.sale.MassSalesList;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.Payment;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.PaymentStatus;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.pending.PendingPayment;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.pending.PendingPaymentBuilder;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.product.Product;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.product.ProductsList;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.server.Server;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.server.ServersList;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.http.client.HttpClient;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationService;

import java.util.concurrent.TimeUnit;

/**
 * The EasyDonate API client that will be used for all
 * further operations with the platform API.
 * @author soknight
 */
public interface EasyDonateClient {

    /**
     * Create a new EasyDonate API client instance with minimal customization.
     * @param accessKey the access key of your shop on the EasyDonate site.
     * @return The created API client instance.
     */
    static @NotNull EasyDonateClient create(@NotNull String accessKey) {
        return create(accessKey, Constants.USER_AGENT, Constants.CONNECT_TIMEOUT, Constants.READ_TIMEOUT, Constants.WRITE_TIMEOUT);
    }

    /**
     * Create a new EasyDonate API client instance using a custom User-Agent.
     * @param accessKey the access key of your shop on the EasyDonate site.
     * @param userAgent the User-Agent header value for all further HTTP requests.
     * @return The created API client instance.
     */
    static @NotNull EasyDonateClient create(@NotNull String accessKey, @NotNull String userAgent) {
        return create(accessKey, Constants.USER_AGENT, Constants.CONNECT_TIMEOUT, Constants.READ_TIMEOUT, Constants.WRITE_TIMEOUT);
    }

    /**
     * Create a new EasyDonate API client instance using a custom timeout values.
     * @param accessKey the access key of your shop on the EasyDonate site.
     * @param connectTimeout the connection establishing timeout.
     * @param readTimeout the API response awaiting and reading timeout.
     * @param writeTimeout the API request writing and sending timeout.
     * @return The created API client instance.
     */
    static @NotNull EasyDonateClient create(
            @NotNull String accessKey,
            long connectTimeout,
            long readTimeout,
            long writeTimeout
    ) {
        return create(accessKey, Constants.USER_AGENT, connectTimeout, readTimeout, writeTimeout);
    }

    /**
     * Create a new EasyDonate API client instance with maximum of customization
     * @param accessKey the access key of your shop on the EasyDonate site.
     * @param userAgent the User-Agent header value for all further HTTP requests.
     * @param connectTimeout the connection establishing timeout.
     * @param readTimeout the API response awaiting and reading timeout.
     * @param writeTimeout the API request writing and sending timeout.
     * @return The created API client instance.
     */
    static @NotNull EasyDonateClient create(
            @NotNull String accessKey,
            @NotNull String userAgent,
            long connectTimeout,
            long readTimeout,
            long writeTimeout
    ) {
        return builder()
                .setAccessKey(accessKey)
                .setConnectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .setReadTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .setWriteTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                .setUserAgent(userAgent)
                .create();
    }

    /**
     * Create a new EasyDonate API client builder.<br>
     * Usage of builder is more visually beautiful, but
     * actually all creation methods uses any builder methods.
     * @return The API client builder instance.
     * @see EasyDonateClient.Builder
     */
    static @NotNull EasyDonateClient.Builder builder() {
        return new SimpleEasyDonateClient.SimpleBuilder();
    }

    /**
     * Get a used access key of any shop.
     * @return The shop access key.
     * @see Shop.Extra#getAccessKey()
     */
    @NotNull String getAccessKey();

    /**
     * Get a used HTTP client implementation that was actually registered.
     * @return The HTTP client implementation.
     * @see HttpClient
     */
    @NotNull HttpClient getHttpClient();

    /**
     * Get a used JSON serialization service implementation that was actually registered.
     * @return The JSON serialization service implementation.
     */
    @NotNull JsonSerializationService getJsonSerialization();

    /**
     * Get the shop related data.
     * @return The shop describing object.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see Shop
     */
    @NotNull Shop getShop() throws HttpRequestException, HttpResponseException;

    /**
     * Get the shop product by the #ID.
     * @param productId the ID of requested product.
     * @return The product describing object.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see Product
     */
    @NotNull Product getProduct(int productId) throws HttpRequestException, HttpResponseException;

    /**
     * Get the list of all shop products.
     * @return The list of products.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see Product
     */
    @NotNull ProductsList getProductsList() throws HttpRequestException, HttpResponseException;

    /**
     * Get the shop connected server by the #ID.
     * @param serverId the ID of requested connected server.
     * @return The connected server describing object.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see Server
     */
    @NotNull Server getServer(int serverId) throws HttpRequestException, HttpResponseException;

    /**
     * Get the list of all shop connected servers.
     * @return The list of connected servers.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see Server
     */
    @NotNull ServersList getServersList() throws HttpRequestException, HttpResponseException;

    /**
     * Get the list of all mass sales.
     * @return The list of mass sales.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see MassSale
     */
    @NotNull MassSalesList getMassSalesList() throws HttpRequestException, HttpResponseException;

    /**
     * Get the list of all mass sales with the activity filter.
     * @param activityFlag the activity flag to filter the list of stored mass sales.
     * @return The filtered list of mass sales.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see MassSale
     * @see ActivityFlag
     */
    @NotNull MassSalesList getMassSalesList(@NotNull ActivityFlag activityFlag) throws HttpRequestException, HttpResponseException;

    /**
     * Get the list of all coupons.
     * @return The list of coupons.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see Coupon
     */
    @NotNull CouponsList getCouponsList() throws HttpRequestException, HttpResponseException;

    /**
     * Get the list of all coupons with the activity filter.
     * @param activityFlag the activity flag to filter the list of stored coupons.
     * @return The filtered list of coupons.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see Coupon
     * @see ActivityFlag
     */
    @NotNull CouponsList getCouponsList(@NotNull ActivityFlag activityFlag) throws HttpRequestException, HttpResponseException;

    /**
     * Get the payment by the #ID.
     * @param paymentId the ID of requested payment.
     * @return The payment describing object.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see Payment
     * @see PaymentStatus
     */
    @NotNull Payment getPayment(int paymentId) throws HttpRequestException, HttpResponseException;

    /**
     * Get the list of all finished payments.
     * @return The list of finished payments.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see Payment
     * @see PaymentStatus#SUCCESS
     */
    @NotNull PaymentsList getPaymentsList() throws HttpRequestException, HttpResponseException;

    /**
     * Create a new payment to use the EasyDonate platform only for money receiving.<br>
     * You can generate a new payment and send the link to needed players in your plugin.
     * @return The pending payment builder instance.
     * @see PendingPaymentBuilder
     */
    @NotNull PendingPaymentBuilder createPayment();

    /**
     * Get the pending payment data using your credentials from pending payment builder.<br>
     * This method also will be used by {@link PendingPaymentBuilder#create()}.
     * @param paymentBuilder the further pending payment describing builder instance.
     * @return The pending payment describing object.
     * @throws HttpRequestException when any errors with request sending has occured.
     * @throws HttpResponseException when any errors with response handling has occured.
     * @see PendingPayment
     * @see PendingPaymentBuilder
     * @see #createPayment()
     */
    @NotNull PendingPayment createPayment(@NotNull PendingPaymentBuilder paymentBuilder) throws HttpRequestException, HttpResponseException;

    /**
     * Get the plugin manager for any plugins related operations performing.
     * @return The plugin manager instance for this shop.
     * @see PluginManager
     */
    @NotNull PluginManager getPluginManager();

    /**
     * The EasyDonate API client instance builder.
     * @author soknight
     */
    interface Builder {

        /**
         * Create the API client instance with current specification.
         * @return The created API client instance.
         */
        @NotNull EasyDonateClient create();

        /**
         * Set the shop access key.
         * @param accessKey a new shop access key.
         * @return The builder instance for method chaining continuation.
         */
        @NotNull Builder setAccessKey(@NotNull String accessKey);

        /**
         * Set the connection establishing timeout.
         * @param timeout a digital timeout value.
         * @param timeUnit the time unit of the specified value.
         * @return The builder instance for method chaining continuation.
         */
        @NotNull Builder setConnectTimeout(long timeout, @NotNull TimeUnit timeUnit);

        /**
         * Set the response awaiting timeout.
         * @param timeout a digital timeout value.
         * @param timeUnit the time unit of the specified value.
         * @return The builder instance for method chaining continuation.
         */
        @NotNull Builder setResponseTimeout(long timeout, @NotNull TimeUnit timeUnit);

        /**
         * Set the response awaiting and reading timeout.
         * @param timeout a digital timeout value.
         * @param timeUnit the time unit of the specified value.
         * @return The builder instance for method chaining continuation.
         */
        @NotNull Builder setReadTimeout(long timeout, @NotNull TimeUnit timeUnit);

        /**
         * Set the request writing and sending timeout.
         * @param timeout a digital timeout value.
         * @param timeUnit the time unit of the specified value.
         * @return The builder instance for method chaining continuation.
         */
        @NotNull Builder setWriteTimeout(long timeout, @NotNull TimeUnit timeUnit);

        /**
         * Set the custom User-Agent header value for all further HTTP requests.<br>
         * The default User-Agent is determined by {@link Constants#USER_AGENT}.
         * @param userAgent a new User-Agent header value.
         * @return The builder instance for method chaining continuation.
         */
        @NotNull Builder setUserAgent(@NotNull String userAgent);

    }
    
}
