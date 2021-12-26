package ru.easydonate.easydonate4j.module;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public final class ModuleNotRegisteredException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "Module '%s' has not been registered!";

    private final @NotNull ModuleType moduleType;

    public ModuleNotRegisteredException(@NotNull ModuleType moduleType) {
        super(String.format(MESSAGE_FORMAT, moduleType.getName()));
        this.moduleType = moduleType;
    }

}
