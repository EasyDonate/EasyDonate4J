package ru.soknight.easydonate.sdk.v2.json.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.OptionalDouble;

public class OptionalDoubleDeserializer extends JsonDeserializer<OptionalDouble> {

    @Override
    public OptionalDouble deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String valueAsString = parser.getValueAsString();
        if(valueAsString == null)
            return OptionalDouble.empty();
        
        try {
            return OptionalDouble.of(Double.parseDouble(valueAsString));
        } catch (NumberFormatException ex) {
            return OptionalDouble.empty();
        }
    }

}
