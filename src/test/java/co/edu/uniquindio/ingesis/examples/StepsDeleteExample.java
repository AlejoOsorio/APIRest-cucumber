package co.edu.uniquindio.ingesis.examples;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StepsDeleteExample {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("Existe un ejemplo con ID {int}")
    public void existeUnEjemploConID(int exampleID) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .get("examples/" + exampleID);

        response.then().assertThat().statusCode(200);

        context.setResponse(response);
    }

    @When("elimino el ejemplo con ID {int}")
    public void eliminoElEjemploConID(int exampleID) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .delete("/examples/" + exampleID);
        context.setResponse(response);
    }

    @Given("No existe un ejemplo con ID {int}")
    public void noExisteUnEjemploConID(int exampleID) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .get("examples/" + exampleID);

        if (response.getStatusCode() == 200) {
            response = given()
                    .spec(ApiConfig.BASE_REQUEST)
                    .when()
                    .delete("/examples/" + exampleID);
        }

        context.setResponse(response);
    }
}
