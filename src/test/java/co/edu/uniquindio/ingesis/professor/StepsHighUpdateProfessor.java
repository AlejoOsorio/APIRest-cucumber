package co.edu.uniquindio.ingesis.professor;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepsHighUpdateProfessor {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();
    private Map<String, Object> profesorData = new HashMap<>();

    @When("actualizo completamente el profesor con ID {int} con los nuevos datos")
    public void actualizoCompletamenteElProfesorConIDConLosNuevosDatos(int profesorId) {
        profesorData.put("name", "Juan");
        profesorData.put("lastName", "Pérez");
        profesorData.put("identification", "102");
        profesorData.put("email", "juan.perez@gmail.com");
        profesorData.put("birthDate", "1980-05-10"); // como String, formato yyyy-MM-dd
        profesorData.put("phoneNumber", "3001234567");
        profesorData.put("roles", List.of("PROFESSOR"));

        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .body(profesorData)
                .when()
                .put("/professors/" + profesorId);

        context.setResponse(response);
    }

    @And("el cuerpo de la respuesta debe contener los datos actualizados del profesor")
    public void elCuerpoDeLaRespuestaDebeContenerLosDatosActualizadosDelProfesor() {
        JsonPath json = response.jsonPath();

        assertEquals(profesorData.get("name"), json.getString("name"));
        assertEquals(profesorData.get("lastName"), json.getString("lastName"));
        assertEquals(profesorData.get("identification"), json.getString("identification"));
        assertEquals(profesorData.get("email"), json.getString("email"));
        assertEquals(profesorData.get("phoneNumber"), json.getString("phoneNumber"));
    }
}
