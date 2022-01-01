package ru.easydonate.easydonate4j.json.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapterFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.json.serialization.deserializer.gson.BooleanIntDeserializer;
import ru.easydonate.easydonate4j.json.serialization.deserializer.gson.LocalDateTimeAdapter;
import ru.easydonate.easydonate4j.json.serialization.exclusion.GsonDeserializationExclusionStrategy;
import ru.easydonate.easydonate4j.json.serialization.exclusion.GsonSerializationExclusionStrategy;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.api.v3.gson.PluginModelsRegistry;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.api.v3.gson.PluginResponsesRegistry;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.api.v3.gson.ShopModelsRegistry;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.api.v3.gson.ShopResponsesRegistry;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.callback.gson.CallbackApiModelsRegistry;
import ru.easydonate.easydonate4j.module.ModuleAlreadyRegisteredException;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.module.ModuleType;

import java.time.LocalDateTime;

public final class GsonSerializationService extends AbstractJsonSerializationService {

    private final Gson defaultGson;
    private final Gson prettyGson;

    public GsonSerializationService() {
        TypeAdapterFactory typeAdapterFactory = new GsonTypeAdapterResolver(this);

        this.defaultGson = patchGsonBuilder(typeAdapterFactory, new GsonBuilder()).create();
        this.prettyGson = patchGsonBuilder(typeAdapterFactory, new GsonBuilder()).setPrettyPrinting().create();
    }

    public static void register() throws ModuleAlreadyRegisteredException {
        if(isRegistered())
            throw new ModuleAlreadyRegisteredException(ModuleType.JSON_SERIALIZATION_SERVICE);

        ModuleRegistrator.get().registerJsonSerializationService(new GsonSerializationService());
    }

    public static void registerIfNotRegisteredYet() {
        if(!isRegistered())
            ModuleRegistrator.get().registerJsonSerializationService(new GsonSerializationService());
    }

    public static boolean isRegistered() {
        return ModuleRegistrator.jsonSerializationServiceRegistered(GsonSerializationService.class);
    }

    @Override
    public @NotNull JsonSerializationServiceType getType() {
        return JsonSerializationServiceType.GSON;
    }

    @Override
    public <T> void registerImplementationAliasesGroup(@NotNull JsonModelsGroup jsonModelsGroup) {
        switch (jsonModelsGroup) {
            case API_V3_SHOP_MODELS:
                registerModelsGroup(jsonModelsGroup, ShopModelsRegistry.getSingleton());
                break;
            case API_V3_SHOP_RESPONSES:
                registerModelsGroup(jsonModelsGroup, ShopResponsesRegistry.getSingleton());
                break;
            case API_V3_PLUGIN_MODELS:
                registerModelsGroup(jsonModelsGroup, PluginModelsRegistry.getSingleton());
                break;
            case API_V3_PLUGIN_RESPONSES:
                registerModelsGroup(jsonModelsGroup, PluginResponsesRegistry.getSingleton());
                break;
            case CALLBACK_API_MODELS:
                registerModelsGroup(jsonModelsGroup, CallbackApiModelsRegistry.getSingleton());
                break;
            default:
                throw new IllegalArgumentException(String.format("An unexpected json models group received: %s!", jsonModelsGroup));
        }
    }

    @Override
    public @Nullable String serialize(@Nullable Object object) throws JsonSerializationException {
        try {
            return defaultGson.toJson(object);
        } catch (JsonParseException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    @Override
    public <T> @Nullable T deserialize(@NotNull Class<T> type, @Nullable String rawJson) throws JsonSerializationException {
        try {
            return defaultGson.fromJson(rawJson, type);
        } catch (JsonParseException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    @Override
    public @NotNull String toPrettyString(@NotNull Object object) throws JsonSerializationException {
        try {
            return prettyGson.toJson(object);
        } catch (JsonParseException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    private @NotNull GsonBuilder patchGsonBuilder(@NotNull TypeAdapterFactory typeAdapterFactory, @NotNull GsonBuilder gsonBuilder) {
        gsonBuilder.serializeNulls();
        gsonBuilder.disableHtmlEscaping();

        gsonBuilder.addSerializationExclusionStrategy(GsonSerializationExclusionStrategy.getSingleton());
        gsonBuilder.addDeserializationExclusionStrategy(GsonDeserializationExclusionStrategy.getSingleton());

        gsonBuilder.registerTypeAdapter(boolean.class, BooleanIntDeserializer.getSingleton());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, LocalDateTimeAdapter.getSingleton());

        gsonBuilder.registerTypeAdapterFactory(typeAdapterFactory);
        return gsonBuilder;
    }

}
