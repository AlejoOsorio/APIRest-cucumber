package co.edu.uniquindio.ingesis.programs;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsCreateProgram {


    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @When("creo un programa con título {string}, descripción {string}, y código {string}")
    public void creoUnProgramaConTítuloDescripciónYCódigo(String title, String description, String code) {
        Map<String, Object> data = new HashMap<>();
        data.put("title", title);
        data.put("description", description);
        data.put("code", code);
        data.put("studentId", 889);

        response =
                given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(data)
                        .when()
                        .post("/programs");

        context.setResponse(response);
    }
}
