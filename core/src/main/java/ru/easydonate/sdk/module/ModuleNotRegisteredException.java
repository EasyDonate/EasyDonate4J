package ru.easydonate.sdk.module;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public final class ModuleNotRegisteredException extends RuntimeException {

    private final @NotNull ModuleType moduleType;

    public ModuleNotRegisteredException(@NotNull ModuleType moduleType) {
        super(String.format("Module '%s' has not been registered!", moduleType.getName()));
        this.moduleType = moduleType;
    }

}
