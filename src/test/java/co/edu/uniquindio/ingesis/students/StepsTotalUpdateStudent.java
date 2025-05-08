package co.edu.uniquindio.ingesis.students;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsTotalUpdateStudent {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();
    private Map<String, Object> data;


    @And("Los datos proporcionados para la actualización completa son validos")
    public void losDatosProporcionadosParaLaActualizaciónCompletaSonValidos() {
        data = new HashMap<>();
        data.put("name", "Laura");
        data.put("lastName", "Gimenez");
        data.put("identification", "333");
        data.put("email", "laura@gmail.com");
        data.put("birthDate", LocalDate.of(1999, 10, 20));
    }

    @When("actualizo completamente al estudiante con ID {int}")
    public void actualizoCompletamenteAlEstudianteConID(int studentId) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .body(data)
                .when()
                .put("/students/" + studentId);

        context.setResponse(response);
    }

    @Given("Los datos proporcionados para la actualización completa son inválidos")
    public void losDatosProporcionadosParaLaActualizaciónCompletaSonInválidos() {
        data = new HashMap<>();
        data.put("name", "Laura");
        data.put("lastName", "Gómez");
        data.put("identification", "333");
        data.put("email", "laura.gomezexamplecom");
        data.put("birthDate", LocalDate.of(1999, 10, 20));
    }
}
