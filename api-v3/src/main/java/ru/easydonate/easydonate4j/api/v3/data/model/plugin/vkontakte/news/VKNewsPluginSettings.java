package ru.easydonate.easydonate4j.api.v3.data.model.plugin.vkontakte.news;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.plugin.PluginSettings;

import java.util.Optional;

public interface VKNewsPluginSettings extends PluginSettings {

    @NotNull Optional<String> getCommunityUrl();

    int getMaxNewsPostsAmount();

}
