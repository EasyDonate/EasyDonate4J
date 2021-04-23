package ru.soknight.easydonate.sdk.v1.json.deserialize;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import ru.soknight.easydonate.sdk.v1.EasyDonateSDK;

public class DateDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException
    {
        String valueAsString = parser.getValueAsString();
        if(valueAsString == null) return null;
        
        TemporalAccessor accessor = EasyDonateSDK.DATE_FORMATTER.parse(valueAsString);
        return accessor != null ? LocalDateTime.from(accessor) : null;
    }

}
