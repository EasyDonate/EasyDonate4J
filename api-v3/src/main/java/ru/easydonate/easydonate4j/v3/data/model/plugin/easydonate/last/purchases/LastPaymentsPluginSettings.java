package ru.easydonate.easydonate4j.v3.data.model.plugin.easydonate.last.purchases;

import ru.easydonate.easydonate4j.v3.data.model.plugin.PluginSettings;

public interface LastPaymentsPluginSettings extends PluginSettings {

    int getVisibleItemsAmount();

    int getTotalShowingItemsLimit();

    boolean isAutoScrollingEnabled();

    boolean isShowingPaymentDate();

}
