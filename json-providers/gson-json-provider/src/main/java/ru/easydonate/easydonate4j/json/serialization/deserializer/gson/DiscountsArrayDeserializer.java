package ru.easydonate.easydonate4j.json.serialization.deserializer.gson;

import com.google.gson.*;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.api.v3.data.model.gson.shop.purchase.DiscountsModel;

import java.lang.reflect.Type;

@AllArgsConstructor
public final class DiscountsArrayDeserializer implements JsonDeserializer<DiscountsModel> {

    private final Gson unsafeGsonInstance;

    @Override
    public @Nullable DiscountsModel deserialize(
            @Nullable JsonElement json,
            @NotNull Type type,
            @NotNull JsonDeserializationContext context
    ) throws JsonParseException {
        if(json == null || json.isJsonNull() || json.isJsonArray())
            return null;

        return unsafeGsonInstance.fromJson(json, type);
    }

}
