package co.edu.uniquindio.ingesis.subjects;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class StepsCreateSubject {


    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("El sistema está listo para aceptar nuevas materias")
    public void elSistemaEstáListoParaAceptarNuevasMaterias() {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        context.setResponse(response);
    }

    @When("el cliente envía una solicitud POST con una materia válida")
    public void elClienteEnvíaUnaSolicitudPOSTConUnaMateriaVálida() {
        Map<String, Object> subjectMap = new HashMap<>();
        subjectMap.put("name", "Programación I");
        subjectMap.put("description", "Introducción a la programación en Java");
        subjectMap.put("credits", 3);

        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .body(subjectMap)
                .when()
                .post("/subjects");

        response.body().print();
        context.setResponse(response);
    }

    @And("el cuerpo de la respuesta debe contener los detalles de la materia creada")
    public void elCuerpoDeLaRespuestaDebeContenerLosDetallesDeLaMateriaCreada() {
        response.then().body(matchesJsonSchemaInClasspath("schemes/subject-scheme.json"));
    }

    @When("el cliente envía una solicitud POST con el nombre vacío")
    public void elClienteEnvíaUnaSolicitudPOSTConElNombreVacío() {
        Map<String, Object> subjectMap = new HashMap<>();
        subjectMap.put("name", "");
        subjectMap.put("description", "Introducción a la programación en Java");
        subjectMap.put("credits", 3);

        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .body(subjectMap)
                .when()
                .post("/subjects");

        response.body().print();
        context.setResponse(response);
    }
}
