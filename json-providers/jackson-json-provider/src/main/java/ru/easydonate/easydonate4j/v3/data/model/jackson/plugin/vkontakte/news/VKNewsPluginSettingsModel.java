package ru.easydonate.easydonate4j.v3.data.model.jackson.plugin.vkontakte.news;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Wrapper;
import ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.news.VKNewsPluginSettings;

import java.util.Objects;
import java.util.Optional;

@Getter
@Implementing(VKNewsPluginSettings.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VKNewsPluginSettingsModel implements VKNewsPluginSettings {

    @JsonProperty("enabled")
    private boolean enabled;
    @JsonProperty("domain")
    private String communityUrl;
    @JsonProperty("count")
    private int maxNewsPostsAmount;

    @JsonIgnore
    @Override
    public @NotNull Optional<String> getCommunityUrl() {
        return Wrapper.wrapNullableOrEmpty(communityUrl);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VKNewsPluginSettingsModel that = (VKNewsPluginSettingsModel) o;
        return enabled == that.enabled &&
                maxNewsPostsAmount == that.maxNewsPostsAmount &&
                Objects.equals(communityUrl, that.communityUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled, communityUrl, maxNewsPostsAmount);
    }

    @Override
    public @NotNull String toString() {
        return "VKNewsPluginSettingsModel{" +
                "enabled=" + enabled +
                ", communityUrl='" + communityUrl + '\'' +
                ", maxNewsPostsAmount=" + maxNewsPostsAmount +
                '}';
    }

}
