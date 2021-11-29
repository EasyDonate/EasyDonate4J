package ru.easydonate.sdk.v3.data.model.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.http.QueryParams;

public enum ActivityFlag {

    ONLY_ACTIVE,
    ONLY_INACTIVE,
    ALL;

    public @NotNull QueryParams addAsQueryParameter(@NotNull QueryParams queryParams) {
        switch (this) {
            case ONLY_ACTIVE:
                return queryParams.add("where_active", true);
            case ONLY_INACTIVE:
                return queryParams.add("where_active", false);
            default:
                return queryParams;
        }
    }

}
