package ru.easydonate.easydonate4j.v3.testing.http.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.http.client.apache.ApacheHttpClientService;
import ru.easydonate.easydonate4j.v3.testing.ordering.TestClassesOrder;

@TestClassesOrder(4)
@DisplayName("Apache Http Client Service Testing")
public final class ApacheHttpClientTesting extends SimpleHttpClientTestingModule {

    @BeforeAll
    public static void init() {
        ApacheHttpClientService.register();
    }

}
