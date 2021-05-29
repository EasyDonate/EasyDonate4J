package ru.soknight.easydonate.sdk.v2.json.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SilentListDeserializer extends JsonDeserializer<List<?>> {

    @Override
    public List<?> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        try {
            return parser.readValueAs(ArrayList.class);
        } catch (IOException ex) {
            return null;
        }
    }

}
