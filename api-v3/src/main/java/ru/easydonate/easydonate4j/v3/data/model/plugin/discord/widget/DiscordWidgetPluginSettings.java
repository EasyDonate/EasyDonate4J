package ru.easydonate.easydonate4j.v3.data.model.plugin.discord.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginSettings;

import java.util.Optional;

public interface DiscordWidgetPluginSettings extends PluginSettings {

    @NotNull Optional<String> getChannelId();

    @NotNull String getWidgetWidth();

    @NotNull String getWidgetHeight();

    @NotNull DiscordWidgetTheme getTheme();

    @NotNull String getThemeRaw();

}
