package ru.easydonate.easydonate4j.api.v3.response.jackson;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.response.ApiResponse;

@Getter
public abstract class JacksonApiResponse<T> implements ApiResponse<T> {

    @JsonProperty("success")
    protected boolean success;
    @JsonProperty("response")
    protected T content;

    @Override
    public @NotNull String toString() {
        return "JacksonApiResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
