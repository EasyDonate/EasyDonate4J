package ru.easydonate.easydonate4j.v3.testing.http.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.http.client.jdk.legacy.JDKLegacyHttpClientService;
import ru.easydonate.easydonate4j.v3.testing.ordering.TestClassesOrder;

@TestClassesOrder(5)
@DisplayName("JDK Legacy Http Client Service Testing")
public final class JDKLegacyHttpClientTesting extends SimpleHttpClientTestingModule {

    @BeforeAll
    public static void init() {
        JDKLegacyHttpClientService.register();
    }

}
