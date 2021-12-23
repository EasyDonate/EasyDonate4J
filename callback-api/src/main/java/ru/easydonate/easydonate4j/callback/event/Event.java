package ru.easydonate.easydonate4j.callback.event;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.callback.client.CallbackApiClient;
import ru.easydonate.easydonate4j.util.Validate;

@Getter
public abstract class Event {

    protected final @NotNull CallbackApiClient client;

    public Event(@NotNull CallbackApiClient client) {
        Validate.notNull(client, "client");
        this.client = client;
    }

    public void fire() {
        client.getEventBus().fireEvent(this);
    }

}
