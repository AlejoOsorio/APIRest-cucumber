package co.edu.uniquindio.ingesis.students;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsDeleteStudent {


    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("Existe un estudiante con ID {string}")
    public void existeUnEstudianteConID(String studentId) {
        response = given()
                .get("students/" + studentId);

        if (response.getStatusCode() == 404) {
            String message = response.jsonPath().getString("message");

            if ("Estudiante no encontrado".equals(message)) {
                HashMap<Object, Object> data = new HashMap<>();
                data = new HashMap<>();
                data.put("name", "Juan");
                data.put("lastName", "Pérez");
                data.put("identification", "123456789");
                data.put("email", "juan.perez@example.com");
                data.put("birthDate", LocalDate.of(2000, 5, 10));

                response = given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(data)
                        .when()
                        .post("/students");
            }
        }

        context.setResponse(response);
    }

    @When("elimino al estudiante con ID {string}")
    public void eliminoAlEstudianteConID(String studentId) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .delete("/students/" + studentId);

        context.setResponse(response);
    }
}
