package ru.easydonate.easydonate4j.json.serialization.failsafe.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.purchase.DiscountsModel;

public final class ApiV3FailsafeModule extends JacksonFailsafeModule {

    public ApiV3FailsafeModule(@NotNull ObjectMapper unsafeMapperInstance) {
        super("API-v3", unsafeMapperInstance);

        // Bug [12.01.22]: some payment objects has an empty array instead of `null` for the `sales` field
        super.addDeserializer(DiscountsModel.class, DiscountsModel.getDeserializer(unsafeMapperInstance));
    }

}
