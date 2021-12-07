package ru.easydonate.easydonate4j.v3.testing.http.client;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.http.client.okhttp.OkHttpClientService;
import ru.easydonate.easydonate4j.v3.testing.ordering.TestClassesOrder;

@TestClassesOrder(7)
@DisplayName("OkHttp3 Http Client Service Testing")
public final class OkHttp3HttpClientTesting extends SimpleHttpClientTestingModule {

    @BeforeAll
    public static void init() {
        OkHttpClientService.register();
    }

}
