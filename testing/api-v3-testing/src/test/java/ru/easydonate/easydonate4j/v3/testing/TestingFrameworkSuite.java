package ru.easydonate.easydonate4j.v3.testing;

import org.junit.platform.suite.api.*;

@Suite
@SuiteDisplayName("EasyDonate4J Testing Framework")
@SelectPackages("ru.easydonate.easydonate4j.v3.testing")
@IncludePackages({
        "ru.easydonate.easydonate4j.v3.testing.http.client",
        "ru.easydonate.easydonate4j.v3.testing.json.serialization"
})
public final class TestingFrameworkSuite {

}
