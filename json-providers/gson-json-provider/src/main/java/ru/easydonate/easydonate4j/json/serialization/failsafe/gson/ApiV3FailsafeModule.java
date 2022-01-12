package ru.easydonate.easydonate4j.json.serialization.failsafe.gson;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.purchase.DiscountsModel;

public final class ApiV3FailsafeModule extends GsonFailsafeModule {

    public ApiV3FailsafeModule(@NotNull Gson unsafeGsonInstance) {
        // Bug [12.01.22]: some payment objects has an empty array instead of `null` for the `sales` field
        super.registerTypeAdapter(DiscountsModel.class, DiscountsModel.getDeserializer(unsafeGsonInstance));
    }

}
