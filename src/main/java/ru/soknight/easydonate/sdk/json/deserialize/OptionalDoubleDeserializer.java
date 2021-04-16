package ru.soknight.easydonate.sdk.json.deserialize;

import java.io.IOException;
import java.util.OptionalDouble;
import java.util.OptionalInt;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class OptionalDoubleDeserializer extends JsonDeserializer<OptionalDouble> {

    @Override
    public OptionalDouble deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException
    {
        String valueAsString = parser.getValueAsString();
        if(valueAsString == null) OptionalInt.empty();
        
        try {
            return OptionalDouble.of(Double.parseDouble(valueAsString));
        } catch (NumberFormatException ex) {
            return OptionalDouble.empty();
        }
    }

}
