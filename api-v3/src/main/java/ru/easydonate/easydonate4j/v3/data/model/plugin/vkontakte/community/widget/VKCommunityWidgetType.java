package ru.easydonate.easydonate4j.v3.data.model.plugin.vkontakte.community.widget;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum VKCommunityWidgetType {

    SHOW_NAME(1),
    SHOW_MEMBERS(3),
    SHOW_NEWS(4),
    UNKNOWN(0);

    private final int mode;

    public static @NotNull VKCommunityWidgetType getByMode(int mode) {
        if(mode == 0)
            return UNKNOWN;

        for(VKCommunityWidgetType communityWidgetType : values())
            if(communityWidgetType.getMode() == mode)
                return communityWidgetType;

        return UNKNOWN;
    }

}
