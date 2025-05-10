package co.edu.uniquindio.ingesis.professor;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class StepsDeleteProfessor {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("existe un profesor con ID {int}")
    public void existeUnProfesorConID(int professorId) {
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

    @When("elimino el profesor con ID {int}")
    public void eliminoElProfesorConID(int professorId) {
        response = given()
                .when()
                .delete("/professors/" + professorId);
        context.setResponse(response);
    }

    @And("el cuerpo de la respuesta debe contener el mensaje {string}")
    public void elCuerpoDeLaRespuestaDebeContenerElMensaje(String message) {
        response.then().body(containsString(message));
    }

    @Given("no existe un profesor con ID {int}")
    public void noExisteUnProfesorConID(int professorId) {
        response = given()
                .get("professors/" + professorId);

        if (response.getStatusCode() == 200) {
                response = given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .when()
                        .delete("/professors" + professorId);
        }

        context.setResponse(response);
    }
}
