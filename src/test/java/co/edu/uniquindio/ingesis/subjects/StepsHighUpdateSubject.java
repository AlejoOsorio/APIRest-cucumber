package co.edu.uniquindio.ingesis.subjects;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsHighUpdateSubject {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();
    private Map<String, Object> subject = new HashMap<>();

    @And("sus datos son correctos")
    public void susDatosSonCorrectos() {
        subject = new HashMap<>();
        subject.put("name", "Estructuras de Datos");
        subject.put("description", "Estudio de modelos relacionales y uso de SQL");
        subject.put("credits", 3);
    }

    @When("actualizo la materia con ID {int}")
    public void actualizoLaMateriaConID(int subjectId) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .body(subject)
                .when()
                .put("/subjects/" + subjectId);

        response.body().print();
        System.out.println(response.getStatusCode());
        context.setResponse(response);
    }

    @And("los datos para acutlizar tienen créditos menores a {int}")
    public void losDatosParaAcutlizarTienenCréditosMenoresA(int subjectId) {
        subject = new HashMap<>();
        subject.put("name", "Estructuras de Datos");
        subject.put("description", "Estudio de modelos relacionales y uso de SQL");
        subject.put("credits", 0);
    }
}
