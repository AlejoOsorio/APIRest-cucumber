package co.edu.uniquindio.ingesis.programs;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StepsDeleteProgram {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("Existe un programa con ID {int}")
    public void existeUnProgramaConID(int programID) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .get("programs/" + programID);

        response.then().assertThat().statusCode(200);

        context.setResponse(response);
    }

    @When("elimino el programa con ID {int}")
    public void eliminoElProgramaConID(int programID) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .delete("/programs/" + programID);
        context.setResponse(response);
    }

    @Given("No existe un programa con ID {int}")
    public void noExisteUnProgramaConID(int programID) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .get("programs/" + programID);

        if (response.getStatusCode() == 200) {
            response = given()
                    .spec(ApiConfig.BASE_REQUEST)
                    .when()
                    .delete("/programs" + programID);
        }

        context.setResponse(response);
    }
}
