package ru.easydonate.easydonate4j;

import java.time.format.DateTimeFormatter;

/**
 * The centralized storage of all magic values used in this project :)
 * @author soknight
 */
public final class Constants {

    // API implementations
    public static final String USER_AGENT = "EasyDonate4J";
    public static final int CONNECT_TIMEOUT = 5000;
    public static final int RESPONSE_TIMEOUT = 5000;
    public static final int READ_TIMEOUT = 5000;
    public static final int WRITE_TIMEOUT = 5000;
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // Callback API implementations
    public static final int EVENT_BUS_ASYNC_THREAD_POOL_SIZE = 0;
    public static final boolean SIGNATURE_VERIFICATION_ENABLED = true;

}
