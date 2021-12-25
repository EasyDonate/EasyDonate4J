package ru.easydonate.easydonate4j.api.v3.data.model.shop;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.http.QueryParams;

/**
 * The enum that represents all possible and actual activity flags.
 * <br>
 * This flag can be used to filter the mass sales/coupons list response.
 * @author soknight
 */
public enum ActivityFlag {

    /** Represents a filter for only active items. */
    ONLY_ACTIVE,

    /** Represents a filter for only inactive items. */
    ONLY_INACTIVE,

    /** Represents a filter for any items. */
    ALL;

    /**
     * Add this activity flag constant as a query parameter.
     * @param queryParams the original query params instance.
     * @return The modified query params instance (not a new object).
     */
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
