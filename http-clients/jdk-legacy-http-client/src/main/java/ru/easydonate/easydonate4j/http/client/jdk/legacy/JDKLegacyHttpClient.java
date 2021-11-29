package ru.easydonate.easydonate4j.http.client.jdk.legacy;

import org.jetbrains.annotations.NotNull;
import ru.easydonate.easydonate4j.Constants;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.QueryParams;
import ru.easydonate.easydonate4j.http.client.AbstractHttpClient;
import ru.easydonate.easydonate4j.http.client.HttpClient;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;
import ru.easydonate.easydonate4j.http.response.HttpResponse;
import ru.easydonate.easydonate4j.util.Validate;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class JDKLegacyHttpClient extends AbstractHttpClient {

    public JDKLegacyHttpClient(@NotNull String userAgent, @NotNull Timeouts timeouts) {
        super(userAgent, timeouts);
    }

    private @NotNull HttpResponse executeGet(@NotNull String url, @NotNull Headers headers, @NotNull QueryParams queryParams) throws HttpRequestException {
        Validate.notNull(url, "url");
        Validate.notNull(headers, "headers");
        Validate.notNull(queryParams, "queryParams");

        try {
            HttpURLConnection connection = makeHttpConnection(Method.GET, url + queryParams.getAsString(), headers);

            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            String content = null;

            InputStream inputStream = connection.getInputStream();
            if(inputStream != null) {
                Scanner scanner = new Scanner(inputStream);
                content = scanner.useDelimiter("\\A").next();
            }

            return new EasyHttpResponse(responseCode, responseMessage, content);
        } catch (IOException ex) {
            throw new HttpRequestException(ex);
        }
    }

    @Override
    public @NotNull CompletableFuture<HttpResponse> requestGetAsync(@NotNull String url, @NotNull Headers headers, @NotNull QueryParams queryParams) {
        CompletableFuture<HttpResponse> future = new CompletableFuture<>();

        CompletableFuture.runAsync(() -> {
            try {
                future.complete(executeGet(url, headers, queryParams));
            } catch (HttpRequestException ex) {
                future.completeExceptionally(ex);
            }
        });

        return future;
    }

    private @NotNull HttpURLConnection makeHttpConnection(@NotNull HttpClient.Method method, @NotNull String url, @NotNull Headers headers) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method.name());
        connection.setRequestProperty("User-Agent", userAgent);

        headers.getAsMap().forEach(connection::setRequestProperty);

        connection.setConnectTimeout(Constants.CONNECT_TIMEOUT);
        connection.setReadTimeout(Constants.READ_TIMEOUT);

        return connection;
    }

}
