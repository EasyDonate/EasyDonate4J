package ru.easydonate.sdk.v3.data.model.gson.plugin.discord.widget;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.util.Wrapper;
import ru.easydonate.sdk.v3.data.model.plugin.discord.widget.DiscordWidgetPluginSettings;
import ru.easydonate.sdk.v3.data.model.plugin.discord.widget.DiscordWidgetTheme;

import java.util.Objects;
import java.util.Optional;

@Getter
@Implementing(DiscordWidgetPluginSettings.class)
public class DiscordWidgetPluginSettingsModel implements DiscordWidgetPluginSettings {

    @SerializedName("enabled")
    private boolean enabled;
    @SerializedName("channelId")
    private String channelId;
    @SerializedName("theme")
    private String themeRaw;

    @SerializedName("width")
    private String widgetWidth;
    @SerializedName("height")
    private String widgetHeight;

    @Override
    public @NotNull Optional<String> getChannelId() {
        return Wrapper.wrapNullableOrEmpty(channelId);
    }

    @Override
    public @NotNull DiscordWidgetTheme getTheme() {
        return DiscordWidgetTheme.getByKey(themeRaw);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiscordWidgetPluginSettingsModel that = (DiscordWidgetPluginSettingsModel) o;
        return enabled == that.enabled &&
                Objects.equals(channelId, that.channelId) &&
                Objects.equals(themeRaw, that.themeRaw) &&
                Objects.equals(widgetWidth, that.widgetWidth) &&
                Objects.equals(widgetHeight, that.widgetHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled, channelId, themeRaw, widgetWidth, widgetHeight);
    }

    @Override
    public @NotNull String toString() {
        return "DiscordWidgetPluginSettingsModel{" +
                "enabled=" + enabled +
                ", channelId='" + channelId + '\'' +
                ", themeRaw='" + themeRaw + '\'' +
                ", widgetWidth='" + widgetWidth + '\'' +
                ", widgetHeight='" + widgetHeight + '\'' +
                '}';
    }

}
