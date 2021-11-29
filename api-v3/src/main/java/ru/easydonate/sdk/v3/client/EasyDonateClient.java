package ru.easydonate.sdk.v3.client;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.Constants;
import ru.easydonate.sdk.exception.HttpRequestException;
import ru.easydonate.sdk.exception.HttpResponseException;
import ru.easydonate.sdk.http.client.HttpClient;
import ru.easydonate.sdk.json.serialization.JsonSerializationService;
import ru.easydonate.sdk.v3.data.model.plugin.PluginManager;
import ru.easydonate.sdk.v3.data.model.shop.ActivityFlag;
import ru.easydonate.sdk.v3.data.model.shop.Shop;
import ru.easydonate.sdk.v3.data.model.shop.coupon.CouponsList;
import ru.easydonate.sdk.v3.data.model.shop.mass.sale.MassSalesList;
import ru.easydonate.sdk.v3.data.model.shop.payment.Payment;
import ru.easydonate.sdk.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.sdk.v3.data.model.shop.payment.pending.PendingPayment;
import ru.easydonate.sdk.v3.data.model.shop.payment.pending.PendingPaymentBuilder;
import ru.easydonate.sdk.v3.data.model.shop.product.Product;
import ru.easydonate.sdk.v3.data.model.shop.product.ProductsList;
import ru.easydonate.sdk.v3.data.model.shop.server.Server;
import ru.easydonate.sdk.v3.data.model.shop.server.ServersList;

import java.util.concurrent.TimeUnit;

public interface EasyDonateClient {

    static @NotNull EasyDonateClient create(@NotNull String accessKey) {
        return create(accessKey, Constants.USER_AGENT, Constants.CONNECT_TIMEOUT, Constants.READ_TIMEOUT, Constants.WRITE_TIMEOUT);
    }

    static @NotNull EasyDonateClient create(@NotNull String accessKey, @NotNull String userAgent) {
        return create(accessKey, Constants.USER_AGENT, Constants.CONNECT_TIMEOUT, Constants.READ_TIMEOUT, Constants.WRITE_TIMEOUT);
    }

    static @NotNull EasyDonateClient create(
            @NotNull String accessKey,
            long connectTimeout,
            long readTimeout,
            long writeTimeout
    ) {
        return create(accessKey, Constants.USER_AGENT, connectTimeout, readTimeout, writeTimeout);
    }

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

    static @NotNull EasyDonateClient.Builder builder() {
        return new SimpleEasyDonateClient.SimpleBuilder();
    }

    @NotNull String getAccessKey();

    @NotNull HttpClient getHttpClient();

    @NotNull JsonSerializationService getJsonSerialization();

    @NotNull Shop getShop() throws HttpRequestException, HttpResponseException;

    @NotNull Product getProduct(int productId) throws HttpRequestException, HttpResponseException;

    @NotNull ProductsList getProductsList() throws HttpRequestException, HttpResponseException;

    @NotNull Server getServer(int serverId) throws HttpRequestException, HttpResponseException;

    @NotNull ServersList getServersList() throws HttpRequestException, HttpResponseException;

    @NotNull MassSalesList getMassSalesList() throws HttpRequestException, HttpResponseException;

    @NotNull MassSalesList getMassSalesList(@NotNull ActivityFlag activityFlag) throws HttpRequestException, HttpResponseException;

    @NotNull CouponsList getCouponsList() throws HttpRequestException, HttpResponseException;

    @NotNull CouponsList getCouponsList(@NotNull ActivityFlag activityFlag) throws HttpRequestException, HttpResponseException;

    @NotNull Payment getPayment(int paymentId) throws HttpRequestException, HttpResponseException;

    @NotNull PaymentsList getPaymentsList() throws HttpRequestException, HttpResponseException;

    @NotNull PendingPaymentBuilder createPayment();

    @NotNull PendingPayment createPayment(@NotNull PendingPaymentBuilder paymentBuilder) throws HttpRequestException, HttpResponseException;

    @NotNull PluginManager getPluginManager();

    interface Builder {

        @NotNull EasyDonateClient create();

        @NotNull Builder setAccessKey(@NotNull String accessKey);

        @NotNull Builder setConnectTimeout(long timeout, @NotNull TimeUnit timeUnit);

        @NotNull Builder setResponseTimeout(long timeout, @NotNull TimeUnit timeUnit);

        @NotNull Builder setReadTimeout(long timeout, @NotNull TimeUnit timeUnit);

        @NotNull Builder setWriteTimeout(long timeout, @NotNull TimeUnit timeUnit);

        @NotNull Builder setUserAgent(@NotNull String userAgent);

    }
    
}
