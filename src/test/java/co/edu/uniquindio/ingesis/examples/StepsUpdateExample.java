package co.edu.uniquindio.ingesis.examples;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsUpdateExample {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @When("actualizo el título del ejemplo con ID {int} a {string} y la dificultad a {string}")
    public void actualizoElTítuloDelEjemploConIDAYLaDificultadA(int exampleId, String title, String difficulty) {
        Map<String, Object> updateRequest = new HashMap<>();
        updateRequest.put("title", title);
        updateRequest.put("description", "Ejemplo actualizado que muestra el uso de if, else y switch.");
        updateRequest.put("code", "if (x > 0) { System.out.println(\"Positivo\"); } else { System.out.println(\"Negativo o cero\"); }");
        updateRequest.put("topic", "Java");
        updateRequest.put("difficulty", difficulty);
        updateRequest.put("professorId", 302L);

        response =
                given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(updateRequest)
                        .when()
                        .put("/examples/"+exampleId);

        context.setResponse(response);
    }
}
