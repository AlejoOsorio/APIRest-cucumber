package co.edu.uniquindio.ingesis.subjects;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsLowUpdateSubject {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @When("actualizo algunos campos de la materia con ID {int}")
    public void actualizoAlgunosCamposDeLaMateriaConID(int subjectId) {
        Map<String, Object> updatedSubject = new HashMap<>();
        updatedSubject.put("name", "Algoritmos y Estructuras de Datos Avanzados");
        updatedSubject.put("description", "Estudio de algoritmos complejos y estructuras avanzadas");
        updatedSubject.put("credits", 2);

        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .body(updatedSubject)
                .when()
                .patch("subjects/" + subjectId);

        response.body().print();
        context.setResponse(response);
    }
}
