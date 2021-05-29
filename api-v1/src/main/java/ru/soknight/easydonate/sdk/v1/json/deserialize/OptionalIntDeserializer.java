package ru.soknight.easydonate.sdk.v1.json.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.OptionalInt;

public class OptionalIntDeserializer extends JsonDeserializer<OptionalInt> {

    @Override
    public OptionalInt deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String valueAsString = parser.getValueAsString();
        if(valueAsString == null)
            return OptionalInt.empty();
        
        try {
            return OptionalInt.of(Integer.parseInt(valueAsString));
        } catch (NumberFormatException ex) {
            return OptionalInt.empty();
        }
    }

}
