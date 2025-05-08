package co.edu.uniquindio.ingesis.students;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsPartialUpdateStudent {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @When("actualizo parcialmente al estudiante con ID {int}")
    public void actualizoParcialmenteAlEstudianteConID(int studentId) {
        Map<String, Object> data = new HashMap<>();

        data.put("name", "Juan");
        data.put("lastName", "Pérez");
        data.put("identification", "123456789");
        data.put("email", "juanperez@gmail.com");
        data.put("birthDate", LocalDate.of(2000, 1, 15));  // formato yyyy-MM-dd

        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .body(data)
                .when()
                .patch("/students/" + studentId);

        context.setResponse(response);
    }
}
