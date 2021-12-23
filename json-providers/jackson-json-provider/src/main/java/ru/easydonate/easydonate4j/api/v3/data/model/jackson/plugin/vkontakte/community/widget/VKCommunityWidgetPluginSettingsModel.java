package ru.easydonate.easydonate4j.api.v3.data.model.jackson.plugin.vkontakte.community.widget;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.community.widget.VKCommunityWidgetPluginSettings;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.community.widget.VKCommunityWidgetType;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;

import java.util.Objects;
import java.util.OptionalInt;

@Getter
@Implementing(VKCommunityWidgetPluginSettings.class)
public class VKCommunityWidgetPluginSettingsModel implements VKCommunityWidgetPluginSettings {

    @JsonProperty("enabled")
    private boolean enabled;
    @JsonProperty("id")
    private Integer communityId;
    @JsonProperty("mode")
    private int typeRaw;
    @JsonProperty("no_cover")
    private boolean hidingWidgetCover;

    @JsonProperty("width")
    private String widgetWidth;
    @JsonProperty("height")
    private String widgetHeight;

    @JsonProperty("color1")
    private String backgroundColorRaw;
    @JsonProperty("color2")
    private String textColorRaw;
    @JsonProperty("color3")
    private String buttonColorRaw;

    @JsonIgnore
    @Override
    public @NotNull OptionalInt getCommunityId() {
        return Wrapper.wrapNullableInt(communityId);
    }

    @JsonIgnore
    @Override
    public @NotNull VKCommunityWidgetType getType() {
        return VKCommunityWidgetType.getByMode(typeRaw);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VKCommunityWidgetPluginSettingsModel that = (VKCommunityWidgetPluginSettingsModel) o;
        return enabled == that.enabled &&
                typeRaw == that.typeRaw &&
                hidingWidgetCover == that.hidingWidgetCover &&
                Objects.equals(communityId, that.communityId) &&
                Objects.equals(widgetWidth, that.widgetWidth) &&
                Objects.equals(widgetHeight, that.widgetHeight) &&
                Objects.equals(backgroundColorRaw, that.backgroundColorRaw) &&
                Objects.equals(textColorRaw, that.textColorRaw) &&
                Objects.equals(buttonColorRaw, that.buttonColorRaw);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                enabled, communityId, typeRaw, hidingWidgetCover, widgetWidth,
                widgetHeight, backgroundColorRaw, textColorRaw, buttonColorRaw
        );
    }

    @Override
    public @NotNull String toString() {
        return "VKCommunityWidgetPluginSettingsModel{" +
                "enabled=" + enabled +
                ", communityId=" + communityId +
                ", typeRaw=" + typeRaw +
                ", hidingWidgetCover=" + hidingWidgetCover +
                ", widgetWidth='" + widgetWidth + '\'' +
                ", widgetHeight='" + widgetHeight + '\'' +
                ", backgroundColorRaw='" + backgroundColorRaw + '\'' +
                ", textColorRaw='" + textColorRaw + '\'' +
                ", buttonColorRaw='" + buttonColorRaw + '\'' +
                '}';
    }

}
