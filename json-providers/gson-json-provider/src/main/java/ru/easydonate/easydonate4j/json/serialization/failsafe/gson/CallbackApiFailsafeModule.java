package ru.easydonate.easydonate4j.json.serialization.failsafe.gson;

import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.data.model.gson.purchase.DiscountsModel;

public final class CallbackApiFailsafeModule extends GsonFailsafeModule {

    public CallbackApiFailsafeModule(@NotNull Gson unsafeGsonInstance) {
        // Bug [12.01.22]: some payment objects has an empty array instead of `null` for the `sales` field
        super.registerTypeAdapter(DiscountsModel.class, DiscountsModel.getDeserializer(unsafeGsonInstance));
    }

}
