package ru.soknight.easydonate.sdk.v1.response.deserialize;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class JacksonConverterFactory extends Converter.Factory {
    
    private final ObjectMapper mapper;

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(
            Type type,
            Annotation[] annotations,
            Retrofit retrofit
            ) {
        JavaType javaType = mapper.getTypeFactory().constructType(type);
        ObjectReader reader = mapper.readerFor(javaType);
        return new JacksonResponseBodyConverter<>(reader);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(
            Type type,
            Annotation[] parameterAnnotations,
            Annotation[] methodAnnotations,
            Retrofit retrofit
            ) {
        JavaType javaType = mapper.getTypeFactory().constructType(type);
        ObjectWriter writer = mapper.writerFor(javaType);
        return new JacksonRequestBodyConverter<>(writer);
    }

    public static JacksonConverterFactory create() {
        return create(new ObjectMapper());
    }

    public static JacksonConverterFactory create(ObjectMapper mapper) {
        if(mapper == null) throw new NullPointerException("mapper == null");
        return new JacksonConverterFactory(mapper);
    }
    
}
