package ru.easydonate.sdk.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.sdk.v3.data.model.shop.AdditionalField;

public interface FilledAdditionalField extends AdditionalField {

    @NotNull String getSpecifiedValue();

}
