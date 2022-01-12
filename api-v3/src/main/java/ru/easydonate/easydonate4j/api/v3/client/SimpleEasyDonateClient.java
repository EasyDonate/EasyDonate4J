package ru.easydonate.easydonate4j.api.v3.client;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.Constants;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginManager;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.discord.widget.DiscordWidgetPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.custom.messages.CustomMessagesPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.surcharge.SurchargePlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.community.widget.VKCommunityWidgetPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.messages.widget.VKMessagesWidgetPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.news.VKNewsPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.yandex.metrika.YandexMetrikaPlugin;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.ActivityFlag;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.Shop;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.coupon.CouponsList;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.mass.sale.MassSalesList;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.Payment;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.pending.PendingPayment;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.payment.pending.PendingPaymentBuilder;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.product.Product;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.product.ProductsList;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.server.Server;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.server.ServersList;
import ru.easydonate.easydonate4j.api.v3.exception.HttpResponseFailureException;
import ru.easydonate.easydonate4j.api.v3.response.ApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.ResponseContentDeserializer;
import ru.easydonate.easydonate4j.api.v3.response.plugin.PluginApiResponse;
import ru.easydonate.easydonate4j.api.v3.response.shop.*;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.QueryParams;
import ru.easydonate.easydonate4j.http.client.HttpClient;
import ru.easydonate.easydonate4j.http.request.EasyHttpRequest;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationService;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.util.Validate;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Getter
public class SimpleEasyDonateClient implements EasyDonateClient {

    public static final String API_ENDPOINT = "https://easydonate.ru/api/v3";

    protected final String accessKey;
    protected final PluginManager pluginManager;

    protected final Headers defaultHeaders;
    protected final HttpClient httpClient;
    protected final JsonSerializationService jsonSerialization;

    protected SimpleEasyDonateClient(
            @NotNull String accessKey,
            @NotNull String userAgent,
            long connectTimeout,
            long responseTimeout,
            long readTimeout,
            long writeTimeout
    ) {
        Validate.notEmpty(accessKey, "accessKey");
        Validate.notEmpty(userAgent, "userAgent");

        this.accessKey = accessKey;
        this.pluginManager = new SimplePluginManager(this);

        this.defaultHeaders = new Headers()
                .add("Accept-Charset", StandardCharsets.UTF_8.name())
                .add("Shop-Key", accessKey)
                .add("User-Agent", userAgent);

        this.httpClient = ModuleRegistrator.httpClientService().buildClient()
                .setApiEndpoint(API_ENDPOINT)
                .setConnectTimeout(connectTimeout)
                .setResponseTimeout(responseTimeout)
                .setReadTimeout(readTimeout)
                .setWriteTimeout(writeTimeout)
                .setUserAgent(userAgent)
                .create();

        this.jsonSerialization = ModuleRegistrator.jsonSerializationService();
        this.jsonSerialization.registerImplementationAliasesGroup(JsonModelsGroup.API_V3_MODELS);
    }

    @Override
    public @NotNull String getAccessKey() {
        return accessKey;
    }

    @Override
    public @NotNull Shop getShop() throws HttpRequestException, HttpResponseException {
        return executeShopRequest(GetShopResponse.class, "/shop");
    }

    @Override
    public @NotNull Product getProduct(int productId) throws HttpRequestException, HttpResponseException {
        Validate.isTrue(productId > 0, "'productId' must be greater than 0!");
        return executeShopRequest(GetProductResponse.class, "/shop/product/%d", productId);
    }

    @Override
    public @NotNull ProductsList getProductsList() throws HttpRequestException, HttpResponseException {
        return executeShopRequest(GetProductsListResponse.class, "/shop/products");
    }

    @Override
    public @NotNull Server getServer(int serverId) throws HttpRequestException, HttpResponseException {
        Validate.isTrue(serverId > 0, "'serverId' must be greater than 0!");
        return executeShopRequest(GetServerResponse.class, "/shop/server/%d", serverId);
    }

    @Override
    public @NotNull ServersList getServersList() throws HttpRequestException, HttpResponseException {
        return executeShopRequest(GetServersListResponse.class, "/shop/servers");
    }

    @Override
    public @NotNull MassSalesList getMassSalesList() throws HttpRequestException, HttpResponseException {
        return getMassSalesList(ActivityFlag.ALL);
    }

    @Override
    public @NotNull MassSalesList getMassSalesList(@NotNull ActivityFlag activityFlag) throws HttpRequestException, HttpResponseException {
        Validate.notNull(activityFlag, "activityFlag");
        QueryParams queryParams = activityFlag.addAsQueryParameter(new QueryParams());
        return executeShopRequest(GetMassSalesListResponse.class, "/shop/massSales", queryParams);
    }

    @Override
    public @NotNull CouponsList getCouponsList() throws HttpRequestException, HttpResponseException {
        return getCouponsList(ActivityFlag.ALL);
    }

    @Override
    public @NotNull CouponsList getCouponsList(@NotNull ActivityFlag activityFlag) throws HttpRequestException, HttpResponseException {
        Validate.notNull(activityFlag, "activityFlag");
        QueryParams queryParams = activityFlag.addAsQueryParameter(new QueryParams());
        return executeShopRequest(GetCouponsListResponse.class, "/shop/coupons", queryParams);
    }

    @Override
    public @NotNull Payment getPayment(int paymentId) throws HttpRequestException, HttpResponseException {
        Validate.isTrue(paymentId > 0, "'paymentId' must be greater than 0!");
        return executeShopRequest(GetPaymentResponse.class, "/shop/payment/%d", paymentId);
    }

    @Override
    public @NotNull PaymentsList getPaymentsList() throws HttpRequestException, HttpResponseException {
        return executeShopRequest(GetPaymentsListResponse.class, "/shop/payments");
    }

    @Override
    public @NotNull PendingPaymentBuilder createPayment() {
        return new PendingPaymentBuilder(this);
    }

    @Override
    public @NotNull PendingPayment createPayment(@NotNull PendingPaymentBuilder paymentBuilder) throws HttpRequestException, HttpResponseException {
        Validate.notNull(paymentBuilder, "paymentBuilder");
        return executeShopRequest(CreatePaymentResponse.class, "/shop/payment/create", paymentBuilder.toQueryParams());
    }

    protected <T> @NotNull T executeShopRequest(
            @NotNull Class<? extends ApiResponse<T>> responseType,
            @NotNull String apiPath,
            @Nullable Object... pathArgs
    ) throws HttpRequestException, HttpResponseException {
        return executeShopRequest(responseType, apiPath, null, pathArgs);
    }

    protected <T> @NotNull T executeShopRequest(
            @NotNull Class<? extends ApiResponse<T>> responseType,
            @NotNull String apiPath,
            @Nullable QueryParams queryParams,
            @Nullable Object... pathArgs
    ) throws HttpRequestException, HttpResponseException {
        EasyHttpRequest httpRequest = createRequest(HttpClient.Method.GET)
                .setApiPath(apiPath, pathArgs)
                .setHeaders(defaultHeaders)
                .setQueryParams(queryParams)
                .build();
        
        return request(responseType, httpRequest);
    }

    protected <T> @NotNull T executePluginRequest(
            @NotNull Class<? extends ApiResponse<T>> responseType,
            @NotNull Headers headers,
            @Nullable QueryParams queryParams
    ) throws HttpRequestException, HttpResponseException {
        Validate.notNull(responseType, "responseType");
        Validate.notNull(headers, "headers");

        PluginApiResponse annotation = responseType.getAnnotation(PluginApiResponse.class);
        if(annotation == null)
            throw new IllegalArgumentException(String.format("A response type '%s' isn't annotated by the @PluginApiResponse!", responseType.getName()));

        PluginType pluginType = annotation.pluginType();
        String apiMethod = annotation.apiMethod();

        EasyHttpRequest httpRequest = createRequest(HttpClient.Method.GET)
                .setApiPath("/plugin/%s/%s", pluginType.getApiName(), apiMethod)
                .setHeaders(headers)
                .setQueryParams(queryParams)
                .build();

        return request(responseType, httpRequest);
    }

    @Override
    public <T> @NotNull T request(
            @NotNull Class<? extends ApiResponse<T>> responseObjectType, 
            @NotNull EasyHttpRequest httpRequest
    ) throws HttpRequestException, HttpResponseException {
        Validate.notNull(responseObjectType, "responseObjectType");
        Validate.notNull(httpRequest, "httpRequest");
        
        EasyHttpResponse httpResponse = httpClient.execute(httpRequest);
        if(httpResponse.isSuccess())
            return ResponseContentDeserializer.deserializeResponseContent(responseObjectType, httpResponse);
        else
            throw new HttpResponseFailureException(httpResponse);
    }

    @Override
    public @NotNull <T> CompletableFuture<T> requestAsync(
            @NotNull Class<? extends ApiResponse<T>> responseObjectType, 
            @NotNull EasyHttpRequest httpRequest
    ) {
        Validate.notNull(responseObjectType, "responseObjectType");
        Validate.notNull(httpRequest, "httpRequest");

        CompletableFuture<T> future = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                future.complete(request(responseObjectType, httpRequest));
            } catch (HttpRequestException | HttpResponseException ex) {
                future.completeExceptionally(ex);
            }
        });

        return future;
    }

    @Override
    public @NotNull EasyHttpRequest.Builder createRequest(@NotNull HttpClient.Method method) {
        Validate.notNull(method, "method");
        return httpClient.createRequest(method);
    }

    static final class SimpleBuilder implements EasyDonateClient.Builder {

        private String accessKey;
        private String userAgent = Constants.USER_AGENT;
        private long connectTimeout = Constants.CONNECT_TIMEOUT;
        private long responseTimeout = Constants.RESPONSE_TIMEOUT;
        private long readTimeout = Constants.READ_TIMEOUT;
        private long writeTimeout = Constants.WRITE_TIMEOUT;

        @Override
        public @NotNull EasyDonateClient create() {
            return new SimpleEasyDonateClient(accessKey, userAgent, connectTimeout, responseTimeout, readTimeout, writeTimeout);
        }

        @Override
        public @NotNull Builder setAccessKey(@NotNull String accessKey) {
            Validate.notEmpty(accessKey, "accessKey");
            this.accessKey = accessKey;
            return this;
        }

        @Override
        public @NotNull Builder setConnectTimeout(long timeout, @NotNull TimeUnit timeUnit) {
            Validate.notNull(timeUnit, "timeUnit");
            this.connectTimeout = timeout > 0 ? timeUnit.toMillis(timeout) : 0;
            return this;
        }

        @Override
        public @NotNull Builder setResponseTimeout(long timeout, @NotNull TimeUnit timeUnit) {
            Validate.notNull(timeUnit, "timeUnit");
            this.responseTimeout = timeout > 0 ? timeUnit.toMillis(timeout) : 0;
            return this;
        }

        @Override
        public @NotNull Builder setReadTimeout(long timeout, @NotNull TimeUnit timeUnit) {
            Validate.notNull(timeUnit, "timeUnit");
            this.readTimeout = timeout > 0 ? timeUnit.toMillis(timeout) : 0;
            return this;
        }

        @Override
        public @NotNull Builder setWriteTimeout(long timeout, @NotNull TimeUnit timeUnit) {
            Validate.notNull(timeUnit, "timeUnit");
            this.writeTimeout = timeout > 0 ? timeUnit.toMillis(timeout) : 0;
            return this;
        }

        @Override
        public @NotNull Builder setUserAgent(@NotNull String userAgent) {
            Validate.notEmpty(userAgent, "userAgent");
            this.userAgent = userAgent;
            return this;
        }

    }

    @Getter
    public static final class SimplePluginManager implements PluginManager {

        private final SimpleEasyDonateClient client;

        private SimplePluginManager(@NotNull SimpleEasyDonateClient client) {
            this.client = client;
        }

        @Override
        public @NotNull SurchargePlugin getSurchargePlugin() {
            return new SurchargePlugin(client, this::executePluginRequestSafely);
        }

        @Override
        public @NotNull LastPaymentsPlugin getLastPaymentsPlugin() {
            return new LastPaymentsPlugin(client, this::executePluginRequestSafely);
        }

        @Override
        public @NotNull CustomMessagesPlugin getCustomMessagesPlugin() {
            return new CustomMessagesPlugin(client, this::executePluginRequestSafely);
        }

        @Override
        public @NotNull DiscordWidgetPlugin getDiscordWidgetPlugin() {
            return new DiscordWidgetPlugin(client, this::executePluginRequestSafely);
        }

        @Override
        public @NotNull VKCommunityWidgetPlugin getVKCommunityWidgetPlugin() {
            return new VKCommunityWidgetPlugin(client, this::executePluginRequestSafely);
        }

        @Override
        public @NotNull VKMessagesWidgetPlugin getVKMessagesWidgetPlugin() {
            return new VKMessagesWidgetPlugin(client, this::executePluginRequestSafely);
        }

        @Override
        public @NotNull VKNewsPlugin getVKNewsPlugin() {
            return new VKNewsPlugin(client, this::executePluginRequestSafely);
        }

        @Override
        public @NotNull YandexMetrikaPlugin getYandexMetrikaPlugin() {
            return new YandexMetrikaPlugin(client, this::executePluginRequestSafely);
        }

        public <T> @NotNull T executePluginRequestSafely(
                @NotNull Class<? extends ApiResponse<T>> responseType,
                @Nullable QueryParams queryParams
        ) throws HttpRequestException, HttpResponseException {
            return client.executePluginRequest(responseType, client.defaultHeaders, queryParams);
        }

    }

}
