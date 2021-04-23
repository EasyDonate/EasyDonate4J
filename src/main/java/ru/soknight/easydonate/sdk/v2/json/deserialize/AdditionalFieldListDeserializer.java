package ru.soknight.easydonate.sdk.v2.json.deserialize;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import ru.soknight.easydonate.sdk.v2.data.model.AdditionalField;

public class AdditionalFieldListDeserializer extends JsonDeserializer<List<AdditionalField>> {
    
    @Override
    public List<AdditionalField> deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException
    {
        Map<Integer, AdditionalField> map = parser.readValueAs(Map.class);
        if(map == null) return null;
        
        if(map.isEmpty()) return Collections.EMPTY_LIST;
        
        return map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
    
}
