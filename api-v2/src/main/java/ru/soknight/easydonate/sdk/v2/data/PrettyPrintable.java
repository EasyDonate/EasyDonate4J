package ru.soknight.easydonate.sdk.v2.data;

import com.fasterxml.jackson.core.JsonProcessingException;

import ru.soknight.easydonate.sdk.v2.EasyDonateSDK;

/**
 * An interface used to provide pretty-printing feature to all data models.
 * @author soknight
 */
public interface PrettyPrintable {

    /**
     * Print this object to pretty JSON string.
     * @return The pretty JSON string.
     * @throws JsonProcessingException if any exceptions has been throwed during the json serialization.
     */
    default String toPrettyString() throws JsonProcessingException {
        return EasyDonateSDK.OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }
    
}
