package ru.easydonate.easydonate4j.v3.data.model.gson.plugin.easydonate.surcharge;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.json.serialization.Implementing;
import ru.easydonate.easydonate4j.util.Validate;
import ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.surcharge.SurchargePluginSettings;
import ru.easydonate.easydonate4j.v3.data.model.shop.ProductType;

import java.util.Objects;
import java.util.OptionalInt;

@Getter
@Implementing(SurchargePluginSettings.class)
public class SurchargePluginSettingsModel implements SurchargePluginSettings {

    @SerializedName("enabled")
    private boolean enabled;
    @SerializedName("disallow_with_promocodes")
    private boolean disallowedWithPromocodes;
    @SerializedName("duration")
    private int availabilityDuration;

    @SerializedName("enableForGroup")
    private boolean availableForPrivileges;
    @SerializedName("enableForItem")
    private boolean availableForItems;
    @SerializedName("enableForCurrency")
    private boolean availableForCurrencies;
    @SerializedName("enableForOther")
    private boolean availableForOthers;

    @Override
    public @NotNull OptionalInt getAvailabilityDuration() {
        return availabilityDuration > 0 ? OptionalInt.of(availabilityDuration) : OptionalInt.empty();
    }

    @Override
    public boolean isAvailableFor(@NotNull ProductType productType) {
        Validate.notNull(productType, "productType");

        switch (productType) {
            case PRIVILEGE:
                return availableForPrivileges;
            case ITEM:
                return availableForItems;
            case CURRENCY:
                return availableForCurrencies;
            case OTHER:
                return availableForOthers;
            default:
                return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SurchargePluginSettingsModel that = (SurchargePluginSettingsModel) o;
        return enabled == that.enabled &&
                disallowedWithPromocodes == that.disallowedWithPromocodes &&
                availabilityDuration == that.availabilityDuration &&
                availableForPrivileges == that.availableForPrivileges &&
                availableForItems == that.availableForItems &&
                availableForCurrencies == that.availableForCurrencies &&
                availableForOthers == that.availableForOthers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                enabled, disallowedWithPromocodes, availabilityDuration, availableForPrivileges,
                availableForItems, availableForCurrencies, availableForOthers
        );
    }

    @Override
    public @NotNull String toString() {
        return "SurchargePluginSettingsModel{" +
                "enabled=" + enabled +
                ", disallowedWithPromocodes=" + disallowedWithPromocodes +
                ", availabilityDuration=" + availabilityDuration +
                ", availableForPrivileges=" + availableForPrivileges +
                ", availableForItems=" + availableForItems +
                ", availableForCurrencies=" + availableForCurrencies +
                ", availableForOthers=" + availableForOthers +
                '}';
    }

}
