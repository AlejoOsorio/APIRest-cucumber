package co.edu.uniquindio.ingesis.students;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StepsGetStudentId {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("Existe un estudiante con ID {int}")
    public void existeUnEstudianteConID(int studentId) {
        response = given()
                .get("students/" + studentId);

        if (response.getStatusCode() == 404) {
            String message = response.jsonPath().getString("message");

            if ("Profesor no encontrado".equals(message)) {
                HashMap<Object, Object> data = new HashMap<>();
                data.put("name", "Mario");
                data.put("lastName", "Pérez");
                data.put("identification", "1456789");
                data.put("email", "mario@gmail.com");
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

    @When("consulto al estudiante con ID {int}")
    public void consultoAlEstudianteConID(int studentId) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .get("students/" + studentId);

        context.setResponse(response);
    }

    @Given("No existe un estudiante con ID {int}")
    public void noExisteUnEstudianteConID(int studentId) {
        response = given()
                .get("students/" + studentId);

        if (response.getStatusCode() == 200) {

            response = given()
                    .spec(ApiConfig.BASE_REQUEST)
                    .when()
                    .delete("students/" + studentId);
        }

        context.setResponse(response);
    }
}
