package ru.easydonate.easydonate4j.api.v3.data.model.gson.plugin.easydonate.custom.messages;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.custom.messages.CustomMessagePosition;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.custom.messages.CustomMessagesPluginSettings;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;

import java.util.Objects;
import java.util.Optional;

@Getter
@Implementing(CustomMessagesPluginSettings.class)
public class CustomMessagesPluginSettingsModel implements CustomMessagesPluginSettings {

    @SerializedName("enabled")
    private boolean enabled;
    @SerializedName("message")
    private String messageText;
    @SerializedName("position")
    private String positionRaw;

    @SerializedName("buttonCaption")
    private String buttonCaption;
    @SerializedName("buttonUrl")
    private String buttonLink;

    @Override
    public @NotNull CustomMessagePosition getPosition() {
        return CustomMessagePosition.getByKey(positionRaw);
    }

    @Override
    public @NotNull Optional<String> getButtonLink() {
        return Wrapper.wrapNullableOrEmpty(buttonLink);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomMessagesPluginSettingsModel that = (CustomMessagesPluginSettingsModel) o;
        return enabled == that.enabled &&
                Objects.equals(messageText, that.messageText) &&
                Objects.equals(positionRaw, that.positionRaw) &&
                Objects.equals(buttonCaption, that.buttonCaption) &&
                Objects.equals(buttonLink, that.buttonLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled, messageText, positionRaw, buttonCaption, buttonLink);
    }

    @Override
    public @NotNull String toString() {
        return "CustomMessagesPluginSettingsModel{" +
                "enabled=" + enabled +
                ", messageText='" + messageText + '\'' +
                ", positionRaw='" + positionRaw + '\'' +
                ", buttonCaption='" + buttonCaption + '\'' +
                ", buttonLink='" + buttonLink + '\'' +
                '}';
    }

}
