package co.edu.uniquindio.ingesis;

import io.cucumber.java.en.*;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    @Given("an example scenario")
    public void anExampleScenario() {
        System.out.println("Example scenario");
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
        System.out.println("Step definitions are implemented");
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
//        System.out.println("Scenario passes");
    }

}
