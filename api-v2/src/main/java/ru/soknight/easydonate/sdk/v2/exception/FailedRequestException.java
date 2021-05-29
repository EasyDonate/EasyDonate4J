package ru.soknight.easydonate.sdk.v2.exception;

public class FailedRequestException extends Exception {
    private static final long serialVersionUID = 6960691633479490285L;

    public FailedRequestException(String message) {
        this(message, null);
    }

    public FailedRequestException(Throwable cause) {
        this(null, cause);
    }

    public FailedRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
