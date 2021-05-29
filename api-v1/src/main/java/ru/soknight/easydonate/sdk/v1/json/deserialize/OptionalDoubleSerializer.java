package ru.soknight.easydonate.sdk.v1.json.deserialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.OptionalDouble;

public class OptionalDoubleSerializer extends JsonSerializer<OptionalDouble> {

    @Override
    public void serialize(OptionalDouble value, JsonGenerator generator, SerializerProvider serializers)
            throws IOException
    {
        if(value.isPresent())
            generator.writeNumber(value.getAsDouble());
    }

}
