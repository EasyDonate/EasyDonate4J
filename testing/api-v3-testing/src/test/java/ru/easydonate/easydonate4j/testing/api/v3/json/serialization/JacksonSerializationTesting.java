package ru.easydonate.easydonate4j.testing.api.v3.json.serialization;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.testing.api.v3.ordering.TestClassesOrder;
import ru.easydonate.easydonate4j.json.serialization.JacksonSerializationService;

@TestClassesOrder(2)
@DisplayName("Jackson Serialization Service Testing")
public final class JacksonSerializationTesting extends SimpleJsonSerializationTestingModule {

    @BeforeAll
    public static void init() {
        JacksonSerializationService.register();
    }

}
