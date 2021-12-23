package ru.easydonate.easydonate4j.callback.data.model.server;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

public interface Server extends PrettyPrintable {

    int getId();

    @NotNull String getName();

    @NotNull String getAddress();

    int getPort();

}
