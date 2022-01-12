package ru.easydonate.easydonate4j.json.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.json.serialization.failsafe.jackson.ApiV3FailsafeModule;
import ru.easydonate.easydonate4j.json.serialization.failsafe.jackson.CallbackApiFailsafeModule;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.JsonModelsGroup;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.jackson.ApiV3ModelsRegistry;
import ru.easydonate.easydonate4j.json.serialization.implementation.registry.jackson.CallbackApiModelsRegistry;
import ru.easydonate.easydonate4j.module.ModuleAlreadyRegisteredException;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.module.ModuleType;

public final class JacksonSerializationService extends AbstractJsonSerializationService {

    private final ObjectMapper objectMapper;

    public JacksonSerializationService() {
        this.objectMapper = createObjectMapper();
    }

    public static void register() throws ModuleAlreadyRegisteredException {
        if(isRegistered())
            throw new ModuleAlreadyRegisteredException(ModuleType.JSON_SERIALIZATION_SERVICE);

        ModuleRegistrator.get().registerJsonSerializationService(new JacksonSerializationService());
    }

    public static void registerIfNotRegisteredYet() {
        if(!isRegistered())
            ModuleRegistrator.get().registerJsonSerializationService(new JacksonSerializationService());
    }

    public static boolean isRegistered() {
        return ModuleRegistrator.jsonSerializationServiceRegistered(JacksonSerializationService.class);
    }

    @Override
    public @NotNull JsonSerializationServiceType getType() {
        return JsonSerializationServiceType.JACKSON;
    }

    @Override
    public <T> void registerImplementationAliasesGroup(@NotNull JsonModelsGroup jsonModelsGroup) {
        switch (jsonModelsGroup) {
            case API_V3_MODELS:
                registerModelsGroup(jsonModelsGroup, ApiV3ModelsRegistry.getSingleton());
                new ApiV3FailsafeModule(createObjectMapper()).register(objectMapper);
                break;
            case CALLBACK_API_MODELS:
                registerModelsGroup(jsonModelsGroup, CallbackApiModelsRegistry.getSingleton());
                new CallbackApiFailsafeModule(createObjectMapper()).register(objectMapper);
                break;
            default:
                throw new IllegalArgumentException(String.format("An unexpected json models group received: %s!", jsonModelsGroup));
        }
    }

    @Override
    public @Nullable String serialize(@Nullable Object object) throws JsonSerializationException {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    @Override
    public <T> @Nullable T deserialize(@NotNull Class<T> type, @Nullable String rawJson) throws JsonSerializationException {
        try {
            return objectMapper.readValue(rawJson, type);
        } catch (JsonProcessingException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    @Override
    public @NotNull String toPrettyString(@NotNull Object object) throws JsonSerializationException {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new JsonSerializationException(ex);
        }
    }

    private @NotNull ObjectMapper createObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JacksonSerializationModule(this));
        return objectMapper;
    }

}
