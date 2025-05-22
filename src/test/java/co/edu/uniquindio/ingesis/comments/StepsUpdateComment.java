package co.edu.uniquindio.ingesis.comments;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsUpdateComment {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @When("actualizo el contenido del comentario con ID {int} a {string}")
    public void actualizoElContenidoDelComentarioConIDA(int commentId, String newComment) {
        Map<String, Object> datos = new HashMap<>();
        datos.put("programId", 101);
        datos.put("content", newComment);

        response =
                given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(datos)
                        .when()
                        .put("/comments/"+commentId);

        context.setResponse(response);
    }
}
