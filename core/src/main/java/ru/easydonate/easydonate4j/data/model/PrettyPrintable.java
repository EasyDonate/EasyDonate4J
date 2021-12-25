package ru.easydonate.easydonate4j.data.model;

import ru.easydonate.easydonate4j.exception.JsonSerializationException;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;

/**
 * The interface that used to provide pretty-printing feature to all data models.
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
