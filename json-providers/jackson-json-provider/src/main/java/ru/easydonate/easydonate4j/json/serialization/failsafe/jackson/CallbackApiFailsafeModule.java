package ru.easydonate.easydonate4j.json.serialization.failsafe.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.data.model.jackson.purchase.DiscountsModel;

public final class CallbackApiFailsafeModule extends JacksonFailsafeModule {

    public CallbackApiFailsafeModule(@NotNull ObjectMapper unsafeMapperInstance) {
        super("Callback-API", unsafeMapperInstance);

        // Bug [12.01.22]: some payment objects has an empty array instead of `null` for the `sales` field
        super.addDeserializer(DiscountsModel.class, DiscountsModel.getDeserializer(unsafeMapperInstance));
    }

}
