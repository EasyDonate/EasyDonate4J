package ru.easydonate.easydonate4j.api.v3.data.model.shop.purchase;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.data.model.shop.AdditionalField;

public interface FilledAdditionalField extends AdditionalField {

    @NotNull String getSpecifiedValue();

}
