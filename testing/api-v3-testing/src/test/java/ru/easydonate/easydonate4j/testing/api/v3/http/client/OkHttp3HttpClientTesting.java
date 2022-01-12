package ru.easydonate.easydonate4j.testing.api.v3.http.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.testing.api.v3.ordering.TestClassesOrder;
import ru.easydonate.easydonate4j.http.client.okhttp.OkHttpClientService;

@TestClassesOrder(7)
@DisplayName("OkHttp3 Http Client Service Testing")
public final class OkHttp3HttpClientTesting extends SimpleHttpClientTestingModule {

    @BeforeAll
    public static void init() {
        OkHttpClientService.registerIfNotRegisteredYet();
    }

}
