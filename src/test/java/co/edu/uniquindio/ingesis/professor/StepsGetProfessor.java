package co.edu.uniquindio.ingesis.professor;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class StepsGetProfessor {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("existe un profesor con ID {int} con datos validos")
    public void existeUnProfesorConIDConDatosValidos(int professorId) {
        response = given()
                .get("professors/" + professorId);

        if (response.getStatusCode() == 404) {
            String message = response.jsonPath().getString("message");

            if ("Profesor no encontrado".equals(message)) {
                HashMap<Object, Object> data = new HashMap<>();
                data.put("name", "Juan");
                data.put("lastName", "Garcia");
                data.put("identification", "3698754");
                data.put("email", "juan@gmail.com");
                data.put("birthDate", "2000-09-19");
                data.put("phoneNumber", "3669554875");


                response = given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(data)
                        .when()
                        .post("/professors");
            }
        }

        context.setResponse(response);
    }

    @When("solicito la información del profesor con ID {int}")
    public void solicitoLaInformaciónDelProfesorConID(int professorId) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .get("professors/" + professorId);

        context.setResponse(response);
    }

    @And("el cuerpo de la respuesta debe contener los datos del profesor:")
    public void elCuerpoDeLaRespuestaDebeContenerLosDatosDelProfesor() {
        response.then().body(matchesJsonSchemaInClasspath("schemes/professor-scheme.json"));
    }
}
