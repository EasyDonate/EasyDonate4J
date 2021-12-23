package ru.easydonate.easydonate4j.api.v3.data.model.plugin;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.util.Validate;
import ru.easydonate.easydonate4j.api.v3.client.EasyDonateClient;

@Getter
public abstract class AbstractPlugin implements Plugin {

    protected final EasyDonateClient client;
    protected final PluginRequestExecutor requestExecutor;
    protected final PluginType pluginType;

    public AbstractPlugin(
            @NotNull EasyDonateClient client,
            @NotNull PluginRequestExecutor requestExecutor,
            @NotNull PluginType pluginType
    ) {
        Validate.notNull(client, "client");
        Validate.notNull(requestExecutor, "requestExecutor");
        Validate.notNull(pluginType, "pluginType");
        this.client = client;
        this.requestExecutor = requestExecutor;
        this.pluginType = pluginType;
    }

}
