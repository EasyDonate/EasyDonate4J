package ru.easydonate.easydonate4j.v3.testing.json.serialization;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import ru.easydonate.easydonate4j.v3.json.serialization.GsonSerializationService;
import ru.easydonate.easydonate4j.v3.testing.ordering.TestClassesOrder;

@TestClassesOrder(3)
@DisplayName("GSON Serialization Service Testing")
public final class GsonSerializationTesting extends SimpleJsonSerializationTestingModule {

    @BeforeAll
    public static void init() {
        GsonSerializationService.register();
    }

}
