package ru.easydonate.easydonate4j.v3.response.plugin;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PluginApiResponse {

    @NotNull PluginType pluginType();

    @NotNull String apiMethod();

}
