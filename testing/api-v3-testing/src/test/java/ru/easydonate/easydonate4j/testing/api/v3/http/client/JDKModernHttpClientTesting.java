package ru.easydonate.easydonate4j.testing.api.v3.http.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.testing.api.v3.ordering.TestClassesOrder;
import ru.easydonate.easydonate4j.http.client.jdk.modern.JDKModernHttpClientService;

@TestClassesOrder(6)
@DisplayName("JDK Modern Http Client Service Testing")
public final class JDKModernHttpClientTesting extends SimpleHttpClientTestingModule {

    @BeforeAll
    public static void init() {
        JDKModernHttpClientService.register();
    }

}
