package ru.easydonate.easydonate4j.testing.api.v3.json.serialization;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.testing.api.v3.ordering.TestClassesOrder;
import ru.easydonate.easydonate4j.json.serialization.GsonSerializationService;

@TestClassesOrder(3)
@DisplayName("GSON Serialization Service Testing")
public final class GsonSerializationTesting extends SimpleJsonSerializationTestingModule {

    @BeforeAll
    public static void init() {
        GsonSerializationService.register();
    }

}
