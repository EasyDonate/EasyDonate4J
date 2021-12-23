package ru.easydonate.easydonate4j.api.v3.response.gson;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.api.v3.response.ErrorResponse;
import ru.easydonate.easydonate4j.json.serialization.Implementing;

@Getter
@Implementing(ErrorResponse.class)
public final class GsonErrorResponse extends GsonApiResponse<String> implements ErrorResponse {

    @SerializedName("error_code")
    private int errorCode;

    @Override
    public @NotNull String toString() {
        return "GsonErrorResponse{" +
                "success=" + success +
                ", content=" + content +
                ", errorCode=" + errorCode +
                '}';
    }

}
