package ru.easydonate.sdk.data.model;

import ru.easydonate.sdk.exception.JsonSerializationException;
import ru.easydonate.sdk.module.ModuleRegistrator;

/**
 * An interface used to provide pretty-printing feature to all data models.
 * @author soknight
 */
public interface PrettyPrintable {

    /**
     * Print this object to pretty JSON string.
     * @return The pretty JSON string.
     * @throws JsonSerializationException if any exceptions has been throwed during the json serialization.
     * @throws IllegalStateException if json serialization provider isn't registered.
     */
    default String toPrettyString() throws JsonSerializationException {
        return ModuleRegistrator.get().getJsonSerializationService().toPrettyString(this);
    }
    
}
