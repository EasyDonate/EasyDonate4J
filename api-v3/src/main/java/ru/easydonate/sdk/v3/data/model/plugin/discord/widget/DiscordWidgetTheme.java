package ru.easydonate.sdk.v3.data.model.plugin.discord.widget;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DiscordWidgetTheme {

    LIGHT("light"),
    DARK("dark"),
    UNKNOWN("unknown");

    private final String key;

    public static @NotNull DiscordWidgetTheme getByKey(@Nullable String key) {
        if(key == null || key.isEmpty())
            return UNKNOWN;

        for(DiscordWidgetTheme discordWidgetTheme : values())
            if(discordWidgetTheme.getKey().equalsIgnoreCase(key))
                return discordWidgetTheme;

        return UNKNOWN;
    }

}
