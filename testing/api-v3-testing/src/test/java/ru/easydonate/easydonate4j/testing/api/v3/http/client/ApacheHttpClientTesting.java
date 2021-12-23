package ru.easydonate.easydonate4j.testing.api.v3.http.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.testing.api.v3.ordering.TestClassesOrder;
import ru.easydonate.easydonate4j.http.client.apache.ApacheHttpClientService;

@TestClassesOrder(4)
@DisplayName("Apache Http Client Service Testing")
public final class ApacheHttpClientTesting extends SimpleHttpClientTestingModule {

    @BeforeAll
    public static void init() {
        ApacheHttpClientService.register();
    }

}
