package ru.easydonate.easydonate4j.callback.event.handler;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.callback.event.Event;
import ru.easydonate.easydonate4j.callback.exception.EventHandleFailException;

import java.lang.reflect.Method;

public interface EventHandler<E extends Event> {

    static <E extends Event> @NotNull EventHandler<E> fromParameterizedMethod(
            @NotNull Class<E> eventType,
            @NotNull Method method,
            @Nullable Object instance,
            boolean isAsync
    ) {
        return new ParameterizedMethodHandler<>(eventType, method, instance, isAsync);
    }

    boolean isAsync();

    void handle(@NotNull E event) throws EventHandleFailException;

}
