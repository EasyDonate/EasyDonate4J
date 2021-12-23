package ru.easydonate.easydonate4j;

import java.time.format.DateTimeFormatter;

public final class Constants {

    // API implementations
    public static final String USER_AGENT;
    public static final int CONNECT_TIMEOUT;
    public static final int RESPONSE_TIMEOUT;
    public static final int READ_TIMEOUT;
    public static final int WRITE_TIMEOUT;
    public static final DateTimeFormatter DATE_FORMATTER;

    // Callback API implementations
    public static final int EVENT_BUS_ASYNC_THREAD_POOL_SIZE;
    public static final boolean SIGNATURE_VERIFICATION_ENABLED;

    static {
        USER_AGENT = "EasyDonate4J";
        CONNECT_TIMEOUT = 5000;
        RESPONSE_TIMEOUT = 5000;
        READ_TIMEOUT = 5000;
        WRITE_TIMEOUT = 5000;
        DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        EVENT_BUS_ASYNC_THREAD_POOL_SIZE = 0;
        SIGNATURE_VERIFICATION_ENABLED = true;
    }

}
