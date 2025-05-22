package co.edu.uniquindio.ingesis.programs;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsUpdateProgram {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();


    @When("actualizo el título del programa con ID {int} a {string}")
    public void actualizoElTítuloDelProgramaConIDA(int programId, String title) {
        Map<String, Object> programRequest = new HashMap<>();
        programRequest.put("title", title);
        programRequest.put("description", "Aplicación para registrar y consultar calificaciones de estudiantes.");
        programRequest.put("code", "public class SistemaNotas { public static void main(String[] args) { } }");
        programRequest.put("studentId", 888);

        response =
                given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(programRequest)
                        .when()
                        .put("/programs/"+programId);

        context.setResponse(response);
    }

    @When("actualizo la descripción del programa con ID {int} a {string}")
    public void actualizoLaDescripciónDelProgramaConIDA(int programId, String description) {
        Map<String, Object> programRequest = new HashMap<>();
        programRequest.put("title", "Sistema de Gestión de Notas");
        programRequest.put("description", description);
        programRequest.put("code", "public class SistemaNotas { public static void main(String[] args) { } }");
        programRequest.put("studentId", 888);

        response =
                given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(programRequest)
                        .when()
                        .put("/programs/"+programId);

        context.setResponse(response);
    }
}
