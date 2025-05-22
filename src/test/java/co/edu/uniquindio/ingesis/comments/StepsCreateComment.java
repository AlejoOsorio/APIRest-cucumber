package co.edu.uniquindio.ingesis.comments;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsCreateComment {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @When("creo un comentario con el contenido {string} para el programa con ID {int}")
    public void creoUnComentarioConElContenidoParaElProgramaConID(String content, int programId) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("programId", programId);
        datos.put("content", content);

        response =
                given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(datos)
                        .when()
                        .post("/comments");

        context.setResponse(response);
    }
}
