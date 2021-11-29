package ru.easydonate.sdk.v3.data.model.plugin.easydonate.surcharge;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.exception.HttpRequestException;
import ru.easydonate.sdk.exception.HttpResponseException;
import ru.easydonate.sdk.http.QueryParams;
import ru.easydonate.sdk.util.Validate;
import ru.easydonate.sdk.v3.client.EasyDonateClient;
import ru.easydonate.sdk.v3.data.model.plugin.AbstractPlugin;
import ru.easydonate.sdk.v3.data.model.plugin.PluginRequestExecutor;
import ru.easydonate.sdk.v3.data.model.plugin.PluginType;
import ru.easydonate.sdk.v3.response.plugin.easydonate.surcharge.SurchargeGetDiscountResponse;
import ru.easydonate.sdk.v3.response.plugin.easydonate.surcharge.SurchargeGetDiscountsListResponse;
import ru.easydonate.sdk.v3.response.plugin.easydonate.surcharge.SurchargeGetSettingsResponse;

public final class SurchargePlugin extends AbstractPlugin {

    public SurchargePlugin(@NotNull EasyDonateClient client, @NotNull PluginRequestExecutor requestExecutor) {
        super(client, requestExecutor, PluginType.SURCHARGE);
    }

    @Override
    public @NotNull SurchargePluginSettings getSettings() throws HttpRequestException, HttpResponseException {
        return requestExecutor.executeRequest(SurchargeGetSettingsResponse.class, null, null);
    }

    public @NotNull SurchargeDiscountsList getDiscountsList(@NotNull String customer) throws HttpRequestException, HttpResponseException {
        Validate.notNull(customer, "customer");

        QueryParams queryParams = new QueryParams().add("username", customer);
        return requestExecutor.executeRequest(SurchargeGetDiscountsListResponse.class, null, queryParams);
    }

    public @NotNull SurchargeDiscount getDiscount(@NotNull String customer, int productId) throws HttpRequestException, HttpResponseException {
        Validate.notNull(customer, "customer");
        Validate.isTrue(productId > 0, "'productId' must be greater than 0!");

        QueryParams queryParams = new QueryParams().add("username", customer).add("product_id", productId);
        return requestExecutor.executeRequest(SurchargeGetDiscountResponse.class, null, queryParams);
    }

}
