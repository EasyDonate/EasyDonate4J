package ru.easydonate.easydonate4j.testing.callback.api;

import org.junit.platform.suite.api.IncludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("EasyDonate4J Testing Framework")
@SelectPackages("ru.easydonate.easydonate4j.testing.callback.api")
@IncludePackages("ru.easydonate.easydonate4j.testing.callback.api.callback")
public final class TestingFrameworkSuite {

}
