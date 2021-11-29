package ru.easydonate.sdk.v3.data.model.jackson.plugin.easydonate.last.payments;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.json.serialization.Implementing;
import ru.easydonate.sdk.v3.data.model.plugin.easydonate.last.purchases.LastPaymentsPluginSettings;

import java.util.Objects;

@Getter
@Implementing(LastPaymentsPluginSettings.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastPaymentsPluginSettingsModel implements LastPaymentsPluginSettings {

    @JsonProperty("enabled")
    private boolean enabled;

    @JsonProperty("items")
    private int visibleItemsAmount;
    @JsonProperty("limit")
    private int totalShowingItemsLimit;

    @JsonProperty("autoplay")
    private boolean autoScrollingEnabled;
    @JsonProperty("show_date")
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
