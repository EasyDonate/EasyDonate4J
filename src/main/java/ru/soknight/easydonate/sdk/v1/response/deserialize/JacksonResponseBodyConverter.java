package ru.soknight.easydonate.sdk.v1.response.deserialize;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectReader;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import ru.soknight.easydonate.sdk.v1.EasyDonateSDK;
import ru.soknight.easydonate.sdk.v1.exception.ApiException;
import ru.soknight.easydonate.sdk.v1.exception.InvalidResponseException;
import ru.soknight.easydonate.sdk.v1.response.AbstractResponse;
import ru.soknight.easydonate.sdk.v1.response.ErrorResponse;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class JacksonResponseBodyConverter<T extends AbstractResponse<?>> implements Converter<ResponseBody, T> {
    
    private final ObjectReader adapter;

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            String asString = value.string();
            if(asString == null)
                throw new InvalidResponseException(value);
            
            try {
                T readValue = adapter.readValue(asString);
                if(readValue.isSuccess())
                    return readValue;
            } catch (JsonProcessingException ignored) {}
            
            try {
                ErrorResponse errorResponse = EasyDonateSDK.OBJECT_MAPPER.readValue(asString, ErrorResponse.class);
                throw new ApiException(errorResponse, value);
            } catch (JsonProcessingException ex) {
                throw ex;
            }
        } finally {
            value.close();
        }
    }

}
