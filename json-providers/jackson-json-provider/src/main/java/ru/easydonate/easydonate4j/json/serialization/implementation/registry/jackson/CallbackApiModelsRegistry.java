package ru.easydonate.easydonate4j.json.serialization.implementation.registry.jackson;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.data.model.jackson.mass.sale.MassSaleModel;
import ru.easydonate.easydonate4j.callback.data.model.jackson.payment.PaymentModel;
import ru.easydonate.easydonate4j.callback.data.model.jackson.purchase.*;
import ru.easydonate.easydonate4j.callback.data.model.jackson.server.ServerModel;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.AbstractJsonModelsRegistry;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;

public final class CallbackApiModelsRegistry extends AbstractJsonModelsRegistry {

    private static final CallbackApiModelsRegistry SINGLETON = new CallbackApiModelsRegistry();

    public CallbackApiModelsRegistry() {
        super(JsonModelsGroup.CALLBACK_API_MODELS);
    }

    public static @NotNull CallbackApiModelsRegistry getSingleton() {
        return SINGLETON;
    }

    @Override
    public void register() {
        registerImplementationAliases(
                AdditionalFieldModel.class,
                CouponDiscountModel.class,
                DiscountsModel.class,
                MassSaleDiscountModel.class,
                MassSaleModel.class,
                PaymentModel.class,
                PurchasedProductModel.class,
                ServerModel.class
        );
    }

}
