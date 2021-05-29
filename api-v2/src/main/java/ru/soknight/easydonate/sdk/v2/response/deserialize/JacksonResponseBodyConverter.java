package ru.soknight.easydonate.sdk.v2.response.deserialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectReader;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import ru.soknight.easydonate.sdk.v2.EasyDonateSDK;
import ru.soknight.easydonate.sdk.v2.exception.ApiException;
import ru.soknight.easydonate.sdk.v2.response.AbstractResponse;
import ru.soknight.easydonate.sdk.v2.response.ErrorResponse;

import java.io.IOException;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class JacksonResponseBodyConverter<T extends AbstractResponse<?>> implements Converter<ResponseBody, T> {
    
    private final ObjectReader adapter;

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            String asString = value.string();

            try {
                T readValue = adapter.readValue(asString);
                if(readValue.isSuccess())
                    return readValue;
            } catch (JsonProcessingException ignored) {}

            ErrorResponse errorResponse = EasyDonateSDK.OBJECT_MAPPER.readValue(asString, ErrorResponse.class);
            throw new ApiException(errorResponse, value);
        } finally {
            value.close();
        }
    }

}
