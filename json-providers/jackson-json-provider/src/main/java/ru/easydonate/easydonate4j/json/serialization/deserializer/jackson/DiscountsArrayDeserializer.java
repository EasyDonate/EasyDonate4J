package ru.easydonate.easydonate4j.json.serialization.deserializer.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.api.v3.data.model.jackson.shop.purchase.DiscountsModel;

import java.io.IOException;

@AllArgsConstructor
public final class DiscountsArrayDeserializer extends JsonDeserializer<DiscountsModel> {

    private final ObjectMapper unsafeMapperInstance;

    @Override
    public @Nullable DiscountsModel deserialize(
            @NotNull JsonParser parser,
            @NotNull DeserializationContext context
    ) throws IOException {
        if(parser.getCurrentToken() == JsonToken.START_ARRAY)
            return null;

        return unsafeMapperInstance.readValue(parser, DiscountsModel.class);
    }

}
