package co.edu.uniquindio.ingesis.subjects;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StepsDeleteSubject {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("Existe una materia con ID {int}")
    public void existeUnaMateriaConID(int subjectId) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .get("subjects/" + subjectId);

        if (response.getStatusCode() == 404) {
            String message = response.jsonPath().getString("message");

            if ("Materia no encontrada".equals(message)) {
                HashMap<Object, Object> data;
                data = new HashMap<>();
                data.put("name", "Programación I");
                data.put("description", "Introducción a la programación en Java");
                data.put("credits", 3);

                response = given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(data)
                        .when()
                        .post("/subjects");
            }
        }

        context.setResponse(response);
    }

    @When("elimino la materia con ID {int}")
    public void eliminoLaMateriaConID(int subjectId) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .delete("/subjects/" + subjectId);

        context.setResponse(response);
    }

    @Given("No existe una materia con ID {int}")
    public void noExisteUnaMateriaConID(int subjectId) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .get("subjects/" + subjectId);

        if (response.getStatusCode() == 200) {
            response = given()
                    .spec(ApiConfig.BASE_REQUEST)
                    .when()
                    .delete("/subjects/" + subjectId);
        }

        context.setResponse(response);
    }
}
