package co.edu.uniquindio.ingesis.professor;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class StepsCreateProfessor {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();
    private Map<String, Object> datos;

    @Given("Se tienen datos validos para el profesor")
    public void seTienenDatosValidosParaElProfesor() {
        datos = new HashMap<>();
        datos.put("name", "Michael");
        datos.put("lastName", "Jackson");
        datos.put("identification", "91828272");
        datos.put("email", "michael@gmail.com");
        datos.put("birthDate", "1958-08-29");
        datos.put("phoneNumber", "1003004050");
    }

    @When("registro al nuevo profesor")
    public void registroAlNuevoProfesor() {
        response =
                given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(datos)
                        .when()
                        .post("/professors");
    }

    @Then("la respuesta debe tener el código de estado {int}")
    public void laRespuestaDebeTenerElCódigoDeEstado(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @And("el cuerpo de la respuesta debe contener los datos validos")
    public void elCuerpoDeLaRespuestaDebeContenerLosDatosValidos() {
        response.then().body(matchesJsonSchemaInClasspath("schemes/professor-scheme.json"));
    }

    @Given("Se tienen datos invalidos para el profesor")
    public void seTienenDatosInvalidosParaElProfesor() {
        datos = new HashMap<>();
        datos.put("name", "Michael");
        datos.put("lastName", "Jackson");
        datos.put("identification", "91828272");
        datos.put("email", "michael@gmail.com");
        datos.put("birthDate", "1958/08/29");
        datos.put("phoneNumber", "1003004050");
    }
}
