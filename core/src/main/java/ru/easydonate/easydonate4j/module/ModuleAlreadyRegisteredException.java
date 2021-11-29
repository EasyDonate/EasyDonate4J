package ru.easydonate.easydonate4j.module;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public final class ModuleAlreadyRegisteredException extends RuntimeException {

    private final @NotNull ModuleType moduleType;

    public ModuleAlreadyRegisteredException(@NotNull ModuleType moduleType) {
        super(String.format("Module '%s' is already registered!", moduleType.getName()));
        this.moduleType = moduleType;
    }

}
