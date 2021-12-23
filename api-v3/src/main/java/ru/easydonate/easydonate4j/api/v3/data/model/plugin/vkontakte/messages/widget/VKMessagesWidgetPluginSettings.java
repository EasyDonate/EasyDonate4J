package ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.messages.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginSettings;

import java.util.OptionalInt;

public interface VKMessagesWidgetPluginSettings extends PluginSettings {

    @NotNull OptionalInt getCommunityId();

    @NotNull OptionalInt getExpandDelay();

    boolean isExpandsWithoutSound();

    boolean isNewMessageSoundDisabled();

    boolean isButtonTooltipHidden();

    @NotNull String getButtonTooltip();

}
