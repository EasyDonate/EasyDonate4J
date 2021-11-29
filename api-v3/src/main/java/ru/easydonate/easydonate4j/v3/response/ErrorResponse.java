package ru.easydonate.easydonate4j.v3.response;

public interface ErrorResponse extends ApiResponse<String> {

    int getErrorCode();

    default String getErrorDescription() {
        return ResponseErrorCode.getByNumber(getErrorCode()).getDescription();
    }

}
