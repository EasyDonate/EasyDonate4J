package ru.soknight.easydonate.sdk.v1.json.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.soknight.easydonate.sdk.v1.data.model.AdditionalField;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdditionalFieldListDeserializer extends JsonDeserializer<List<AdditionalField>> {
    
    @Override
    @SuppressWarnings("unchecked")
    public List<AdditionalField> deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        Map<Integer, AdditionalField> map = parser.readValueAs(Map.class);
        if(map == null)
            return null;
        
        if(map.isEmpty())
            return Collections.emptyList();
        
        return new ArrayList<>(map.values());
    }
    
}
