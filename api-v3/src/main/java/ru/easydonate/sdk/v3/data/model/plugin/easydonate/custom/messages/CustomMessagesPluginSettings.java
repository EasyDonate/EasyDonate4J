package ru.easydonate.sdk.v3.data.model.plugin.easydonate.custom.messages;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.v3.data.model.plugin.PluginSettings;

import java.util.Optional;

public interface CustomMessagesPluginSettings extends PluginSettings {

    @NotNull String getMessageText();

    @NotNull String getPositionRaw();

    @NotNull CustomMessagePosition getPosition();

    @NotNull String getButtonCaption();

    @NotNull Optional<String> getButtonLink();

}
