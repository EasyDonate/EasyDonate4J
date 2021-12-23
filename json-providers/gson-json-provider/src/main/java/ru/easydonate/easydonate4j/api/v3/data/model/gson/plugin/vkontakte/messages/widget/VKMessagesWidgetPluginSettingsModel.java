package ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.vkontakte.messages.widget;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.messages.widget.VKMessagesWidgetPluginSettings;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;

import java.util.Objects;
import java.util.OptionalInt;

@Getter
@Implementing(VKMessagesWidgetPluginSettings.class)
public class VKMessagesWidgetPluginSettingsModel implements VKMessagesWidgetPluginSettings {

    @SerializedName("enabled")
    private boolean enabled;
    @SerializedName("id")
    private Integer communityId;
    @SerializedName("expandTimeout")
    private int expandDelay;
    @SerializedName("tooltipButtonText")
    private String buttonTooltip;

    @SerializedName("disableExpandChatSound")
    private boolean expandsWithoutSound;
    @SerializedName("disableNewMessagesSound")
    private boolean newMessageSoundDisabled;
    @SerializedName("disableButtonTooltip")
    private boolean buttonTooltipHidden;

    @Override
    public @NotNull OptionalInt getCommunityId() {
        return Wrapper.wrapNullableInt(communityId);
    }

    @Override
    public @NotNull OptionalInt getExpandDelay() {
        return Wrapper.wrapNullableInt(expandDelay, i -> i > 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VKMessagesWidgetPluginSettingsModel that = (VKMessagesWidgetPluginSettingsModel) o;
        return enabled == that.enabled &&
                expandDelay == that.expandDelay &&
                expandsWithoutSound == that.expandsWithoutSound &&
                newMessageSoundDisabled == that.newMessageSoundDisabled &&
                buttonTooltipHidden == that.buttonTooltipHidden &&
                Objects.equals(communityId, that.communityId) &&
                Objects.equals(buttonTooltip, that.buttonTooltip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                enabled, communityId, expandDelay, buttonTooltip,
                expandsWithoutSound, newMessageSoundDisabled, buttonTooltipHidden
        );
    }

    @Override
    public @NotNull String toString() {
        return "VKMessagesWidgetPluginSettingsModel{" +
                "enabled=" + enabled +
                ", communityId=" + communityId +
                ", expandDelay=" + expandDelay +
                ", buttonTooltip='" + buttonTooltip + '\'' +
                ", expandsWithoutSound=" + expandsWithoutSound +
                ", newMessageSoundDisabled=" + newMessageSoundDisabled +
                ", buttonTooltipHidden=" + buttonTooltipHidden +
                '}';
    }

}
