package ru.easydonate.easydonate4j.module;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public final class ModuleAlreadyRegisteredException extends RuntimeException {

    private static final String MESSAGE_FORMAT = "Module '%s' is already registered!";

    private final @NotNull ModuleType moduleType;

    public ModuleAlreadyRegisteredException(@NotNull ModuleType moduleType) {
        super(String.format(MESSAGE_FORMAT, moduleType.getName()));
        this.moduleType = moduleType;
    }

}
