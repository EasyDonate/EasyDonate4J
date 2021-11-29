package ru.easydonate.sdk.v3.data.model.jackson.plugin.yandex.metrika;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.yandex.metrika.YandexMetrikaPluginSettings;

import java.util.Objects;

@Getter
@Implementing(YandexMetrikaPluginSettings.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class YandexMetrikaPluginSettingsModel implements YandexMetrikaPluginSettings {

    @JsonProperty("enabled")
    private boolean enabled;
    @JsonProperty("id")
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        YandexMetrikaPluginSettingsModel that = (YandexMetrikaPluginSettingsModel) o;
        return enabled == that.enabled && id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled, id);
    }

    @Override
    public @NotNull String toString() {
        return "YandexMetrikaPluginSettingsModel{" +
                "enabled=" + enabled +
                ", id=" + id +
                '}';
    }

}
