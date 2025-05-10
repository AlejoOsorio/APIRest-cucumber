package co.edu.uniquindio.ingesis;

import co.edu.uniquindio.ingesis.utils.SqlTestUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

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
}
