package co.edu.uniquindio.ingesis.subjects;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StepsGetSubject {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();
    private int subjectId;

    @Given("el sistema tiene una materia registrada con ID {int}")
    public void elSistemaTieneUnaMateriaRegistradaConID(int id) {
        this.subjectId = id;
    }

    @When("el cliente solicita la materia con ID {int}")
    public void elClienteSolicitaLaMateriaConID(int id) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .get("/subjects/" + id);
    }

    @Then("el sistema responde con código {int}")
    public void elSistemaRespondeConCodigo(int expectedCode) {
        response.then().statusCode(expectedCode);

    }

    @Given("el sistema no tiene ninguna materia con ID {int}")
    public void elSistemaNoTieneNingunaMateriaConID(int id) {
        this.subjectId = id;

        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .get("/subjects/" + id);
    }
}