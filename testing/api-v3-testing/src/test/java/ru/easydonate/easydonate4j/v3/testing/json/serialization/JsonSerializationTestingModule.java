package ru.easydonate.easydonate4j.v3.testing.json.serialization;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.easydonate.easydonate4j.module.ModuleRegistrator;
import ru.easydonate.easydonate4j.v3.testing.TestingModule;
import ru.easydonate.easydonate4j.v3.testing.ordering.TestClassesOrder;

@TestClassesOrder(2)
public abstract class JsonSerializationTestingModule extends TestingModule {

    @Test
    @DisplayName("Serialization Service Initialization")
    public void printInfo() {
        logger.info("Installed serialization service: " + ModuleRegistrator.get().getJsonSerializationService().getType());
    }

}
