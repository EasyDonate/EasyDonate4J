package ru.easydonate.easydonate4j.api.v3.data.model.plugin.easydonate.custom.messages;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum CustomMessagePosition {

    TOP("top"),
    BOTTOM("bottom"),
    UNKNOWN("unknown");

    private final String key;

    public static @NotNull CustomMessagePosition getByKey(@Nullable String key) {
        if(key == null || key.isEmpty())
            return UNKNOWN;

        for(CustomMessagePosition customMessagePosition : values())
            if(customMessagePosition.getKey().equalsIgnoreCase(key))
                return customMessagePosition;

        return UNKNOWN;
    }

}
