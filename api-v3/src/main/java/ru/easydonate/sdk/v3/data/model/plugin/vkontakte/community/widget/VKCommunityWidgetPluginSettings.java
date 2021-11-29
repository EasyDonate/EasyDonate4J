package ru.easydonate.sdk.v3.data.model.plugin.vkontakte.community.widget;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.v3.data.model.plugin.PluginSettings;

import java.util.OptionalInt;

public interface VKCommunityWidgetPluginSettings extends PluginSettings {

    @NotNull OptionalInt getCommunityId();

    boolean isHidingWidgetCover();

    @NotNull String getWidgetWidth();

    @NotNull String getWidgetHeight();

    @NotNull String getBackgroundColorRaw();

    @NotNull String getTextColorRaw();

    @NotNull String getButtonColorRaw();

    @NotNull VKCommunityWidgetType getType();

    int getTypeRaw();

}
