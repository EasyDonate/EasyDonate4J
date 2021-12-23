package ru.easydonate.easydonate4j.callback.event.handler;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.callback.event.Event;
import ru.easydonate.easydonate4j.callback.event.Listen;
import ru.easydonate.easydonate4j.callback.exception.EventHandleFailException;
import ru.easydonate.easydonate4j.callback.exception.InvalidEventHandlerException;
import ru.easydonate.easydonate4j.util.Validate;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Getter
public final class ParameterizedMethodHandler<E extends Event> implements EventHandler<E> {

    private final Class<E> eventType;
    private final Method method;
    private final Object instance;
    private final boolean async;

    public ParameterizedMethodHandler(
            @NotNull Class<E> eventType,
            @NotNull Method method,
            @Nullable Object instance,
            boolean async
    ) throws InvalidEventHandlerException {
        Validate.notNull(eventType, "eventType");
        Validate.notNull(method, "method");

        this.eventType = eventType;
        this.method = method;
        this.instance = instance;
        this.async = async;

        validateMethod();
    }

    @Override
    public void handle(@NotNull E event) throws EventHandleFailException {
        try {
            method.invoke(instance, event);
        } catch (Throwable ex) {
            throw new EventHandleFailException(ex);
        }
    }

    private void validateMethod() throws InvalidEventHandlerException {
        if(!method.isAnnotationPresent(Listen.class))
            throw new InvalidEventHandlerException(method, "method must be annotated with @Listen!");

        // --- modifiers validation
        int modifiers = method.getModifiers();

        if(!Modifier.isPublic(modifiers))
            throw new InvalidEventHandlerException(method, "method must be public!");

        if(instance == null && !Modifier.isStatic(modifiers))
            throw new InvalidEventHandlerException(method, "an invocation instance must be specified if this method isn't static!");

        // --- parameters validation
        Class<?>[] parameters = method.getParameterTypes();

        if(parameters.length != 1)
            throw new InvalidEventHandlerException(method, "method must has one parameter and it's an event instance (event type: %s)", eventType.getName());

        if(!parameters[0].isAssignableFrom(eventType))
            throw new InvalidEventHandlerException(method, "type of the first parameter must be %s", eventType.getName());
    }

}
