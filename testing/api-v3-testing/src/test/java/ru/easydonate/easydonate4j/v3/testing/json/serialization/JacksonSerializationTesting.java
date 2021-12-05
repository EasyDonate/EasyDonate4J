package ru.easydonate.easydonate4j.v3.testing.json.serialization;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.v3.json.serialization.JacksonSerializationService;

@DisplayName("Jackson Serialization Service Testing")
public class JacksonSerializationTesting extends SimpleJsonSerializationTestingModule {

    @BeforeAll
    public static void init() {
        JacksonSerializationService.register();
    }

}
