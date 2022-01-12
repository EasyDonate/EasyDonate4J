package ru.easydonate.easydonate4j.json.serialization.failsafe;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.purchase.DiscountsModel;
import ru.easydonate.easydonate4j.json.serialization.deserializer.jackson.DiscountsArrayDeserializer;

public final class JacksonFailsafeModule extends SimpleModule {

    public JacksonFailsafeModule(@NotNull ObjectMapper unsafeMapperInstance) {
        super("EasyDonate4J-FailSafe");

        // Bug [12.01.22]: some payment objects has an empty array instead of `null` for the `sales` field
        super.addDeserializer(DiscountsModel.class, new DiscountsArrayDeserializer(unsafeMapperInstance));
    }

}
