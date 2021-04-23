package ru.soknight.easydonate.sdk.v2.json.deserialize;

import java.io.IOException;
import java.util.OptionalInt;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class OptionalIntDeserializer extends JsonDeserializer<OptionalInt> {

    @Override
    public OptionalInt deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException
    {
        String valueAsString = parser.getValueAsString();
        if(valueAsString == null) OptionalInt.empty();
        
        try {
            return OptionalInt.of(Integer.parseInt(valueAsString));
        } catch (NumberFormatException ex) {
            return OptionalInt.empty();
        }
    }

}
