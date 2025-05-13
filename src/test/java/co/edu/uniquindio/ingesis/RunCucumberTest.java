package co.edu.uniquindio.ingesis;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("co.edu.uniquindio.ingesis")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/report.html, json:target/cucumber-reports/report.json, junit:target/cucumber-reports/report.xml")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "co.edu.uniquindio.ingesis")
public class RunCucumberTest {
}
