package co.edu.uniquindio.ingesis;

import co.edu.uniquindio.ingesis.utils.SqlTestUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.AfterClass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Iniciando escenario: " + scenario.getName());
        SqlTestUtils.executeFileSql("src/test/resources/sql/data.sql");
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Finalizando escenario: " + scenario.getName());
    }

    @AfterStep
    public void afterStep() {
        System.out.println("Paso completado");
    }

    @AfterClass
    public static void generateReport() {
        File reportOutputDirectory = new File("target/cucumber-reports");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber.json");

        Configuration configuration = new Configuration(reportOutputDirectory, "Mi Proyecto");
        configuration.addClassifications("Plataforma", "Windows");
        configuration.addClassifications("Navegador", "Chrome");
        configuration.addClassifications("Versión", "1.0");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
