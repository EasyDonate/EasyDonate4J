package ru.easydonate.easydonate4j.testing.api.v3.http.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.testing.api.v3.ordering.TestClassesOrder;
import ru.easydonate.easydonate4j.http.client.jdk.legacy.JDKLegacyHttpClientService;

@TestClassesOrder(5)
@DisplayName("JDK Legacy Http Client Service Testing")
public final class JDKLegacyHttpClientTesting extends SimpleHttpClientTestingModule {

    @BeforeAll
    public static void init() {
        JDKLegacyHttpClientService.register();
    }

}
