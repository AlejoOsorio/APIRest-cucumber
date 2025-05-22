package co.edu.uniquindio.ingesis.examples;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsCreateExample {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @When("creo un ejemplo con título {string}, descripción {string}, código {string}, tema {string}, dificultad {string}, y asociado al profesor con ID {int}")
    public void creoUnEjemploConTítuloDescripciónCódigoTemaDificultadYAsociadoAlProfesorConID(String title, String description, String code, String topic, String difficult, int proffessorID) {
        Map<String, Object> data = new HashMap<>();
        data.put("title", title);
        data.put("description", description);
        data.put("code", code);
        data.put("topic", topic);
        data.put("difficulty", difficult);
        data.put("professorId", proffessorID);

        response =
                given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(data)
                        .when()
                        .post("/examples/professor/"+proffessorID);

        response.prettyPrint();
        context.setResponse(response);
    }
}
