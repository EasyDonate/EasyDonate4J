package ru.easydonate.easydonate4j.http.client.jdk.legacy;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.easydonate.easydonate4j.Constants;
import ru.easydonate.easydonate4j.exception.HttpRequestException;
import ru.easydonate.easydonate4j.http.Headers;
import ru.easydonate.easydonate4j.http.client.AbstractHttpClient;
import ru.easydonate.easydonate4j.http.client.HttpClient;
import ru.easydonate.easydonate4j.http.request.EasyHttpRequest;
import ru.easydonate.easydonate4j.http.response.SimpleEasyHttpResponse;
import ru.easydonate.easydonate4j.http.response.EasyHttpResponse;
import ru.easydonate.easydonate4j.util.Validate;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class JDKLegacyHttpClient extends AbstractHttpClient {

    public JDKLegacyHttpClient(@NotNull String userAgent, @NotNull Timeouts timeouts) {
        super(userAgent, timeouts);
    }

    public @NotNull EasyHttpResponse execute(@NotNull EasyHttpRequest httpRequest) throws HttpRequestException {
        Validate.notNull(httpRequest, "httpRequest");

        String url = httpRequest.resolveUrl();
        Method method = httpRequest.getMethod();
        Headers headers = httpRequest.getHeaders();

        try {
            HttpURLConnection connection = makeHttpConnection(method, url, headers);

            if(method.isHasBody() && httpRequest.hasBody()) {
                String body = httpRequest.getBody();
                connection.setDoOutput(true);

                OutputStream outputStream = connection.getOutputStream();
                if(outputStream != null) {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                    bufferedWriter.write(body);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                }
            }

            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();
            String content = null;

            InputStream inputStream = connection.getInputStream();
            if(inputStream != null) {
                Scanner scanner = new Scanner(inputStream);
                content = scanner.useDelimiter("\\A").next();
                scanner.close();
            }

            return new SimpleEasyHttpResponse(responseCode, responseMessage, content);
        } catch (IOException ex) {
            throw new HttpRequestException(ex);
        }
    }

    private @NotNull HttpURLConnection makeHttpConnection(@NotNull HttpClient.Method method, @NotNull String url, @Nullable Headers headers) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod(method.getName());
        connection.setRequestProperty("User-Agent", userAgent);

        if(headers != null)
            headers.getAsMap().forEach(connection::setRequestProperty);

        connection.setConnectTimeout(Constants.CONNECT_TIMEOUT);
        connection.setReadTimeout(Constants.READ_TIMEOUT);
        return connection;
    }

}
