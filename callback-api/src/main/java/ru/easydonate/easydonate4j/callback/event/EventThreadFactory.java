package ru.easydonate.easydonate4j.callback.event;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class EventThreadFactory implements ThreadFactory {

    private final AtomicInteger threadIndexer;

    public EventThreadFactory() {
        this.threadIndexer = new AtomicInteger();
    }

    @Override
    public @NotNull Thread newThread(@NotNull Runnable task) {
        int index = threadIndexer.getAndIncrement();
        return new Thread(task, "EasyDonate4J-AsyncEventHandler-#" + index);
    }

}
