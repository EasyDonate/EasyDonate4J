package ru.soknight.easydonate.sdk.v2.json.deserialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class SilentListDeserializer extends JsonDeserializer<List<?>> {

    @Override
    public List<?> deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException
    {
        try {
            return parser.readValueAs(ArrayList.class);
        } catch (IOException ex) {
            return null;
        }
    }

}
