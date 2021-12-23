package ru.easydonate.easydonate4j.api.v3.data.model.shop.payment;

import org.jetbrains.annotations.NotNull;

public interface SentCommand {

    @NotNull String getCommand();

    @NotNull String getResponse();

}
