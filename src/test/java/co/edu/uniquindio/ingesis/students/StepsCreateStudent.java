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
import static org.hamcrest.Matchers.containsString;

public class StepsCreateStudent {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();
    private Map<String, Object> studentMap;

    @Given("Se tienen datos válidos para el estudiante")
    public void seTienenDatosVálidosParaElEstudiante() {
        studentMap = new HashMap<>();
        studentMap.put("name", "Juan");
        studentMap.put("lastName", "Pérez");
        studentMap.put("identification", "123456789");
        studentMap.put("email", "juan.perez@example.com");
        studentMap.put("birthDate", LocalDate.of(2000, 5, 10));
    }

    @When("registro al nuevo estudiante")
    public void registroAlNuevoEstudiante() {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .body(studentMap)
                .when()
                .post("/students");

        context.setResponse(response);
    }

    @Given("Se tiene el correo invalido para el estudiante")
    public void seTieneElCorreoInvalidoParaElEstudiante() {
        studentMap = new HashMap<>();
        studentMap.put("name", "Juan");
        studentMap.put("lastName", "Pérez");
        studentMap.put("identification", "123456789");
        studentMap.put("email", "juan.perez");
        studentMap.put("birthDate", LocalDate.of(2000, 5, 10));
    }

    @And("el cuerpo de la respuesta debe mostrar el mensaje {string}")
    public void elCuerpoDeLaRespuestaDebeMostrarElMensaje(String message) {
        response.then().body(containsString(message));
    }
}
