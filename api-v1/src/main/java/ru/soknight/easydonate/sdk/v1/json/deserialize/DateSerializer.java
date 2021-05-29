package ru.soknight.easydonate.sdk.v1.json.deserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import ru.soknight.easydonate.sdk.v1.EasyDonateSDK;

import java.io.IOException;
import java.time.LocalDateTime;

public class DateSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime value, JsonGenerator generator, SerializerProvider serializers)
            throws IOException
    {
        generator.writeString(value != null ? value.format(EasyDonateSDK.DATE_FORMATTER) : null);
    }

}
