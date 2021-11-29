package ru.easydonate.easydonate4j.v3.data.model.gson.plugin.easydonate.last.payments;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPluginSettings;

import java.util.Objects;

@Getter
@Implementing(LastPaymentsPluginSettings.class)
public class LastPaymentsPluginSettingsModel implements LastPaymentsPluginSettings {

    @SerializedName("enabled")
    private boolean enabled;

    @SerializedName("items")
    private int visibleItemsAmount;
    @SerializedName("limit")
    private int totalShowingItemsLimit;

    @SerializedName("autoplay")
    private boolean autoScrollingEnabled;
    @SerializedName("show_date")
    private boolean showingPaymentDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LastPaymentsPluginSettingsModel that = (LastPaymentsPluginSettingsModel) o;
        return enabled == that.enabled &&
                visibleItemsAmount == that.visibleItemsAmount &&
                totalShowingItemsLimit == that.totalShowingItemsLimit &&
                autoScrollingEnabled == that.autoScrollingEnabled &&
                showingPaymentDate == that.showingPaymentDate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled, visibleItemsAmount, totalShowingItemsLimit, autoScrollingEnabled, showingPaymentDate);
    }

    @Override
    public @NotNull String toString() {
        return "LastPaymentsPluginSettingsModel{" +
                "enabled=" + enabled +
                ", visibleItemsAmount=" + visibleItemsAmount +
                ", totalShowingItemsLimit=" + totalShowingItemsLimit +
                ", autoScrollingEnabled=" + autoScrollingEnabled +
                ", showingPaymentDate=" + showingPaymentDate +
                '}';
    }

}
