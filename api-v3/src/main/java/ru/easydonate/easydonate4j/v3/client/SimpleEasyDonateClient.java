package ru.easydonate.easydonate4j.v3.client;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.Constants;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.exception.HttpResponseException;
import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.QueryParams;
import ru.easydonate.easydonate4j.http.client.HttpClient;
import ru.easydonate.easydonate4j.http.response.HttpResponse;
import ru.easydonate.easydonate4j.json.serialization.JsonSerializationService;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.util.Validate;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginManager;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;
import ru.easydonate.easydonate4j.v3.data.model.plugin.discord.widget.DiscordWidgetPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.custom.messages.CustomMessagesPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.surcharge.SurchargePlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.community.widget.VKCommunityWidgetPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.messages.widget.VKMessagesWidgetPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.news.VKNewsPlugin;
import ru.easydonate.easydonate4j.v3.data.model.plugin.yandex.metrika.YandexMetrikaPlugin;
import ru.easydonate.easydonate4j.v3.data.model.shop.ActivityFlag;
import ru.easydonate.easydonate4j.v3.data.model.shop.Shop;
import ru.easydonate.easydonate4j.v3.data.model.shop.coupon.CouponsList;
import ru.easydonate.easydonate4j.v3.data.model.shop.mass.sale.MassSalesList;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.Payment;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.PaymentsList;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.pending.PendingPayment;
import ru.easydonate.easydonate4j.v3.data.model.shop.payment.pending.PendingPaymentBuilder;
import ru.easydonate.easydonate4j.v3.data.model.shop.product.Product;
import ru.easydonate.easydonate4j.v3.data.model.shop.product.ProductsList;
import ru.easydonate.easydonate4j.v3.data.model.shop.server.Server;
import ru.easydonate.easydonate4j.v3.data.model.shop.server.ServersList;
import ru.easydonate.easydonate4j.v3.exception.ApiResponseFailureException;
import ru.easydonate.easydonate4j.v3.exception.HttpResponseFailureException;
import ru.easydonate.easydonate4j.v3.exception.UnknownApiResponseException;
import ru.easydonate.easydonate4j.v3.response.ApiResponse;
import ru.easydonate.easydonate4j.v3.response.ErrorResponse;
import ru.easydonate.easydonate4j.v3.response.plugin.PluginApiResponse;
import ru.easydonate.easydonate4j.v3.response.shop.*;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Getter
public final class SimpleEasyDonateClient implements EasyDonateClient {

    private static final String API_ENDPOINT = "https://easydonate.ru/api/v3/%s";
    private static final String PLUGIN_API_ENDPOINT = "https://easydonate.ru/api/v3/plugin/%s/%s";

    private final String accessKey;
    private final PluginManager pluginManager;

    private final Headers defaultHeaders;
    private final HttpClient httpClient;
    private final JsonSerializationService jsonSerialization;

    public SimpleEasyDonateClient(
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
                .setConnectTimeout(connectTimeout)
                .setResponseTimeout(responseTimeout)
                .setReadTimeout(readTimeout)
                .setWriteTimeout(writeTimeout)
                .setUserAgent(userAgent)
                .create();

        this.jsonSerialization = ModuleRegistrator.jsonSerializationService();

    }

    @Override
    public @NotNull String getAccessKey() {
        return accessKey;
    }

    @Override
    public @NotNull Shop getShop() throws HttpRequestException, HttpResponseException {
        return requestGetAndParseJson(GetShopResponse.class, "shop");
    }

    @Override
    public @NotNull Product getProduct(int productId) throws HttpRequestException, HttpResponseException {
        Validate.isTrue(productId > 0, "'productId' must be greater than 0!");
        return requestGetAndParseJson(GetProductResponse.class, "shop/product/%d", productId);
    }

    @Override
    public @NotNull ProductsList getProductsList() throws HttpRequestException, HttpResponseException {
        return requestGetAndParseJson(GetProductsListResponse.class, "shop/products");
    }

    @Override
    public @NotNull Server getServer(int serverId) throws HttpRequestException, HttpResponseException {
        Validate.isTrue(serverId > 0, "'serverId' must be greater than 0!");
        return requestGetAndParseJson(GetServerResponse.class, "shop/server/%d", serverId);
    }

    @Override
    public @NotNull ServersList getServersList() throws HttpRequestException, HttpResponseException {
        return requestGetAndParseJson(GetServersListResponse.class, "shop/servers");
    }

    @Override
    public @NotNull MassSalesList getMassSalesList() throws HttpRequestException, HttpResponseException {
        return getMassSalesList(ActivityFlag.ALL);
    }

    @Override
    public @NotNull MassSalesList getMassSalesList(@NotNull ActivityFlag activityFlag) throws HttpRequestException, HttpResponseException {
        Validate.notNull(activityFlag, "activityFlag");
        QueryParams queryParams = activityFlag.addAsQueryParameter(new QueryParams());
        return requestGetAndParseJson(GetMassSalesListResponse.class, "shop/massSales", queryParams);
    }

    @Override
    public @NotNull CouponsList getCouponsList() throws HttpRequestException, HttpResponseException {
        return getCouponsList(ActivityFlag.ALL);
    }

    @Override
    public @NotNull CouponsList getCouponsList(@NotNull ActivityFlag activityFlag) throws HttpRequestException, HttpResponseException {
        Validate.notNull(activityFlag, "activityFlag");
        QueryParams queryParams = activityFlag.addAsQueryParameter(new QueryParams());
        return requestGetAndParseJson(GetCouponsListResponse.class, "shop/coupons", queryParams);
    }

    @Override
    public @NotNull Payment getPayment(int paymentId) throws HttpRequestException, HttpResponseException {
        Validate.isTrue(paymentId > 0, "'paymentId' must be greater than 0!");
        return requestGetAndParseJson(GetPaymentResponse.class, "shop/payment/%d", paymentId);
    }

    @Override
    public @NotNull PaymentsList getPaymentsList() throws HttpRequestException, HttpResponseException {
        return requestGetAndParseJson(GetPaymentsListResponse.class, "shop/payments");
    }

    @Override
    public @NotNull PendingPaymentBuilder createPayment() {
        return new PendingPaymentBuilder(this);
    }

    @Override
    public @NotNull PendingPayment createPayment(@NotNull PendingPaymentBuilder paymentBuilder) throws HttpRequestException, HttpResponseException {
        Validate.notNull(paymentBuilder, "paymentBuilder");
        return requestGetAndParseJson(CreatePaymentResponse.class, "shop/payment/create", paymentBuilder.toQueryParams());
    }

    public <T> @NotNull T executePluginRequest(
            @NotNull Class<? extends ApiResponse<T>> responseType,
            @NotNull Headers headers,
            @NotNull QueryParams queryParams
    ) throws HttpRequestException, HttpResponseException {
        Validate.notNull(responseType, "responseType");
        Validate.notNull(headers, "headers");
        Validate.notNull(queryParams, "queryParams");

        PluginApiResponse annotation = responseType.getAnnotation(PluginApiResponse.class);
        if(annotation == null)
            throw new IllegalArgumentException(String.format("A response type '%s' isn't annotated by the @PluginApiResponse!", responseType.getName()));

        PluginType pluginType = annotation.pluginType();
        String apiMethod = annotation.apiMethod();

        String url = getPluginApiEndpointBasedUrl(pluginType, apiMethod);
        return requestGetAndParseJson(responseType, url, headers, queryParams);
    }

    public <T> @NotNull T requestGetAndParseJson(
            @NotNull Class<? extends ApiResponse<T>> responseObjectType,
            @NotNull String path,
            @Nullable Object... pathArgs
    ) throws HttpRequestException, HttpResponseException {
        return requestGetAndParseJson(responseObjectType, path, defaultHeaders, QueryParams.EMPTY, pathArgs);
    }

    public <T> @NotNull T requestGetAndParseJson(
            @NotNull Class<? extends ApiResponse<T>> responseObjectType,
            @NotNull String path,
            @NotNull QueryParams queryParams,
            @Nullable Object... pathArgs
    ) throws HttpRequestException, HttpResponseException {
        return requestGetAndParseJson(responseObjectType, path, defaultHeaders, queryParams, pathArgs);
    }

    public <T> @NotNull T requestGetAndParseJson(
            @NotNull Class<? extends ApiResponse<T>> responseObjectType,
            @NotNull String path,
            @NotNull Headers headers,
            @Nullable Object... pathArgs
    ) throws HttpRequestException, HttpResponseException {
        return requestGetAndParseJson(responseObjectType, path, headers, QueryParams.EMPTY, pathArgs);
    }

    public <T> @NotNull T requestGetAndParseJson(
            @NotNull Class<? extends ApiResponse<T>> responseObjectType,
            @NotNull String path,
            @NotNull Headers headers,
            @NotNull QueryParams queryParams,
            @Nullable Object... pathArgs
    ) throws HttpRequestException, HttpResponseException {
        String url = getApiEndpointBasedUrl(path, pathArgs);
        return requestGetAndParseJson(responseObjectType, url, headers, queryParams);
    }

    public <T> @NotNull T requestGetAndParseJson(
            @NotNull Class<? extends ApiResponse<T>> responseObjectType,
            @NotNull String url,
            @NotNull Headers headers,
            @NotNull QueryParams queryParams
    ) throws HttpRequestException, HttpResponseException {
        HttpResponse httpResponse = httpClient.requestGet(url, headers, queryParams);

        if(!httpResponse.isSuccess())
            throw new HttpResponseFailureException(httpResponse);

        String content = httpResponse.getContent();

        // trying to parse content as normal response
        try {
            ApiResponse<T> apiResponse = jsonSerialization.deserialize(responseObjectType, content);
            if(apiResponse.isSuccess())
                return apiResponse.getContent();
        } catch (JsonSerializationException ignored) {
        }

        // trying to parse content as error response
        try {
            ErrorResponse errorResponse = jsonSerialization.deserialize(ErrorResponse.class, content);
            throw new ApiResponseFailureException(httpResponse, errorResponse);
        } catch (JsonSerializationException ex) {
            throw new UnknownApiResponseException(httpResponse, ex);
        }
    }

    public @NotNull String getApiEndpointBasedUrl(@NotNull String path, @Nullable Object... args) {
        return String.format(API_ENDPOINT, String.format(path, args));
    }

    public @NotNull String getPluginApiEndpointBasedUrl(@NotNull PluginType pluginType, @NotNull String apiMethod) {
        return String.format(PLUGIN_API_ENDPOINT, pluginType.getApiName(), apiMethod);
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

        public <T> @NotNull T executePluginRequest(
                @NotNull Class<? extends ApiResponse<T>> responseType
        ) throws HttpRequestException, HttpResponseException {
            return executePluginRequest(responseType, client.defaultHeaders, QueryParams.EMPTY);
        }

        public <T> @NotNull T executePluginRequest(
                @NotNull Class<? extends ApiResponse<T>> responseType,
                @NotNull Headers headers
        ) throws HttpRequestException, HttpResponseException {
            return executePluginRequest(responseType, headers, QueryParams.EMPTY);
        }

        public <T> @NotNull T executePluginRequest(
                @NotNull Class<? extends ApiResponse<T>> responseType,
                @NotNull QueryParams queryParams
        ) throws HttpRequestException, HttpResponseException {
            return executePluginRequest(responseType, client.defaultHeaders, queryParams);
        }

        public <T> @NotNull T executePluginRequest(
                @NotNull Class<? extends ApiResponse<T>> responseType,
                @NotNull Headers headers,
                @NotNull QueryParams queryParams
        ) throws HttpRequestException, HttpResponseException {
            return client.executePluginRequest(responseType, headers, queryParams);
        }

        public <T> @NotNull T executePluginRequestSafely(
                @NotNull Class<? extends ApiResponse<T>> responseType,
                @Nullable Headers headers,
                @Nullable QueryParams queryParams
        ) throws HttpRequestException, HttpResponseException {
            Headers actualHeaders = headers != null ? headers : client.defaultHeaders;
            QueryParams actualQueryParams = queryParams != null ? queryParams : QueryParams.EMPTY;
            return client.executePluginRequest(responseType, actualHeaders, actualQueryParams);
        }

    }

}
