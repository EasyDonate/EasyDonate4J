package ru.soknight.easydonate.sdk.v1.json.deserialize;

import java.io.IOException;
import java.util.OptionalInt;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class OptionalIntSerializer extends JsonSerializer<OptionalInt> {

    @Override
    public void serialize(OptionalInt value, JsonGenerator generator, SerializerProvider serializers)
            throws IOException
    {
        if(value.isPresent())
            generator.writeNumber(value.getAsInt());
    }

}
