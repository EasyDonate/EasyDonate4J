package ru.easydonate.easydonate4j.v3.testing.http.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.http.client.jdk.modern.JDKModernHttpClientService;
import ru.easydonate.easydonate4j.v3.testing.ordering.TestClassesOrder;

@TestClassesOrder(6)
@DisplayName("JDK Modern Http Client Service Testing")
public final class JDKModernHttpClientTesting extends SimpleHttpClientTestingModule {

    @BeforeAll
    public static void init() {
        JDKModernHttpClientService.register();
    }

}
