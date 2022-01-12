package ru.easydonate.easydonate4j.json.serialization.failsafe.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.jetbrains.annotations.NotNull;

public abstract class JacksonFailsafeModule extends SimpleModule {

    protected JacksonFailsafeModule(@NotNull String moduleId, @NotNull ObjectMapper unsafeMapperInstance) {
        super("EasyDonate4J-Failsafe-" + moduleId);
    }

    public void register(@NotNull ObjectMapper objectMapper) {
        objectMapper.registerModule(this);
    }

}
