package ru.easydonate.easydonate4j.http.client.okhttp;

import lombok.AllArgsConstructor;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.response.SimpleEasyHttpResponse;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
public final class FuturedCallback implements Callback {

    private final CompletableFuture<EasyHttpResponse> future;

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException ex) {
        future.completeExceptionally(new HttpRequestException(ex));
    }

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response okhttpResponse) {
        try {
            EasyHttpResponse response = parseResponse(okhttpResponse);
            future.complete(response);
        } catch (IOException ex) {
            future.completeExceptionally(new HttpRequestException(ex));
        }
    }

    private @NotNull EasyHttpResponse parseResponse(@NotNull Response okhttpResponse) throws IOException {
        int responseCode = okhttpResponse.code();
        String responseMessage = okhttpResponse.message();

        ResponseBody body = okhttpResponse.body();
        String content = body != null ? body.string() : null;

        return new SimpleEasyHttpResponse(responseCode, responseMessage, content);
    }

}
