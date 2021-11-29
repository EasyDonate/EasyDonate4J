package ru.easydonate.easydonate4j.v3.response.gson;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.v3.response.ApiResponse;

@Getter
public abstract class GsonApiResponse<T> implements ApiResponse<T> {

    @SerializedName("success")
    protected boolean success;
    @SerializedName("response")
    protected T content;

    @Override
    public @NotNull String toString() {
        return "GsonApiResponse{" +
                "success=" + success +
                ", content=" + content +
                '}';
    }

}
