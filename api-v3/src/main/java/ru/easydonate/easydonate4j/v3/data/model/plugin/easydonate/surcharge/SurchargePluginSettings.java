package ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.surcharge;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginSettings;
import ru.easydonate.easydonate4j.v3.data.model.shop.ProductType;

import java.util.OptionalInt;

public interface SurchargePluginSettings extends PluginSettings {

    boolean isDisallowedWithPromocodes();

    @NotNull OptionalInt getAvailabilityDuration();

    boolean isAvailableFor(@NotNull ProductType productType);

    boolean isAvailableForItems();

    boolean isAvailableForPrivileges();

    boolean isAvailableForCurrencies();

    boolean isAvailableForOthers();

}
