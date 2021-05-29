package ru.soknight.easydonate.sdk.v2.json.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.soknight.easydonate.sdk.v2.EasyDonateSDK;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAccessor;

public class DateDeserializer extends JsonDeserializer<LocalDateTime> {

    @Override
    public LocalDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String valueAsString = parser.getValueAsString();
        if(valueAsString == null) return null;
        
        TemporalAccessor accessor = EasyDonateSDK.DATE_FORMATTER.parse(valueAsString);
        return LocalDateTime.from(accessor);
    }

}
