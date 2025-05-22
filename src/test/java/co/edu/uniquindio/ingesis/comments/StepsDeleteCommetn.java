package co.edu.uniquindio.ingesis.comments;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StepsDeleteCommetn {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("Existe un comentario con ID {int}")
    public void existeUnComentarioConID(int commetnId) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .get("comments/" + commetnId);

        response.then().assertThat().statusCode(200);

        context.setResponse(response);
    }

    @When("elimino el comentario con ID {int}")
    public void eliminoElComentarioConID(int commetnId) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .delete("/comments/" + commetnId);
        context.setResponse(response);
    }

    @Given("No existe un comentario con ID {int}")
    public void noExisteUnComentarioConID(int commetnId) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .get("comments/" + commetnId);

        if (response.getStatusCode() == 200) {
            response = given()
                    .spec(ApiConfig.BASE_REQUEST)
                    .when()
                    .delete("/comments" + commetnId);
        }

        context.setResponse(response);
    }
}
