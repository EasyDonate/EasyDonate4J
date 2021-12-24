package ru.easydonate.easydonate4j.callback.event;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.callback.event.handler.EventHandler;
import ru.easydonate.easydonate4j.callback.exception.InvalidEventHandlerException;
import ru.easydonate.easydonate4j.util.Validate;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class EventBus {

    private final Map<Class<?>, List<EventHandler<?>>> eventListeners;
    private final ExecutorService asyncEventsProcessor;

    public EventBus(int threadPoolSize) {
        this.eventListeners = new LinkedHashMap<>();
        this.asyncEventsProcessor = threadPoolSize > 1
                ? Executors.newFixedThreadPool(threadPoolSize, new EventThreadFactory())
                : Executors.newCachedThreadPool(new EventThreadFactory());
    }

    public synchronized void fireEvent(@NotNull Event event) {
        Validate.notNull(event, "event");

        Class<? extends Event> eventType = event.getClass();
        List<EventHandler<?>> eventHandlers = eventListeners.get(eventType);
        if(eventHandlers != null && !eventHandlers.isEmpty())
            eventHandlers.forEach(eventHandler -> fireEvent(event, eventHandler));
    }

    @SuppressWarnings("unchecked")
    private <E extends Event> void fireEvent(@NotNull Event event, @NotNull EventHandler<?> eventHandler) {
        if(eventHandler.isAsync())
            asyncEventsProcessor.submit(() -> ((EventHandler<E>) eventHandler).handle((E) event));
        else
            ((EventHandler<E>) eventHandler).handle((E) event);
    }

    public synchronized <E extends Event> void registerEventHandler(
            @NotNull EventHandler<E> eventHandler,
            @NotNull Class<E> eventType
    ) {
        Validate.notNull(eventHandler, "eventHandler");
        Validate.notNull(eventType, "eventType");

        eventListeners.compute(eventType, (key, value) -> value != null ? value : new ArrayList<>()).add(eventHandler);
    }

    @SuppressWarnings("unchecked")
    public void registerListeners(@NotNull CallbackListener listener) throws InvalidEventHandlerException {
        Validate.notNull(listener, "listener");

        Method[] methods = listener.getClass().getMethods();
        for(Method method : methods) {
            Listen annotation = method.getAnnotation(Listen.class);
            if(annotation == null)
                continue;

            Class<?>[] parameterTypes = method.getParameterTypes();
            if(parameterTypes.length != 1 || !Event.class.isAssignableFrom(parameterTypes[0]))
                continue;

            Class<? extends Event> eventType = (Class<? extends Event>) parameterTypes[0];
            Object instance = Modifier.isStatic(method.getModifiers()) ? null : listener;
            registerMethodAsEventHandler(eventType, method, instance, annotation.isAsync());
        }
    }

    private <E extends Event> void registerMethodAsEventHandler(
            @NotNull Class<E> eventType,
            @NotNull Method method,
            @Nullable Object instance,
            boolean isAsync
    ) throws InvalidEventHandlerException {
        EventHandler<E> eventHandler = EventHandler.fromParameterizedMethod(eventType, method, instance, isAsync);
        registerEventHandler(eventHandler, eventType);
    }

}
