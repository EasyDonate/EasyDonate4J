package ru.easydonate.easydonate4j.http.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class SimpleEasyHttpResponse implements EasyHttpResponse {

    private final int code;
    private final String message;
    private final String content;

    @Override
    public boolean isSuccess() {
        return code / 100 == 2;
    }

}
