package ru.easydonate.easydonate4j.api.v3.data.model.plugin;

import ru.easydonate.easydonate4j.data.model.PrettyPrintable;

/**
 * The parent interface that represents a settings of a platform plugin.
 * @author soknight
 */
public interface PluginSettings extends PrettyPrintable {

    /**
     * Check is this plugin is enabled or not.
     * @return A boolean value: the check result.
     */
    boolean isEnabled();

}
