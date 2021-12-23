package ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.discord.widget;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.discord.widget.DiscordWidgetPluginSettings;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.discord.widget.DiscordWidgetTheme;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;

import java.util.Objects;
import java.util.Optional;

@Getter
@Implementing(DiscordWidgetPluginSettings.class)
public class DiscordWidgetPluginSettingsModel implements DiscordWidgetPluginSettings {

    @JsonProperty("enabled")
    private boolean enabled;
    @JsonProperty("channelId")
    private String channelId;
    @JsonProperty("theme")
    private String themeRaw;

    @JsonProperty("width")
    private String widgetWidth;
    @JsonProperty("height")
    private String widgetHeight;

    @JsonIgnore
    @Override
    public @NotNull Optional<String> getChannelId() {
        return Wrapper.wrapNullableOrEmpty(channelId);
    }

    @JsonIgnore
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
