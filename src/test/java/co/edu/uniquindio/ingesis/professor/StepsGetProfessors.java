package co.edu.uniquindio.ingesis.professor;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepsGetProfessors {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("existen {int} o mas profesores")
    public void existenOMasProfesores(int sizeProfessors) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .get("/professors");


        List<Map<String, Object>> professors = response.body().jsonPath().getList("$");

        if (professors.size() < sizeProfessors) {
            int iterations = sizeProfessors - professors.size();

            for (int i = 0; i <= iterations; i++) {
                HashMap<Object, Object> datos = new HashMap<>();
                datos.put("name", "professor" + i);
                datos.put("lastName", "lastname" + i);
                datos.put("identification", String.valueOf(91828272 + i));
                datos.put("email", "email" + i + "@gmail.com");
                datos.put("birthDate", "1958-08-29");
                datos.put("phoneNumber", String.valueOf(1003004050 + i));

                response = given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(datos)
                        .when()
                        .post("/professors");
            }
        }

        context.setResponse(response);
    }

    @When("solicito la lista de profesores sin parámetros de paginación")
    public void solicitoLaListaDeProfesoresSinParámetrosDePaginación() {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .get("/professors");

        context.setResponse(response);
    }

    @And("la respuesta debe contener {int} elementos")
    public void laRespuestaDebeContenerElementos(int professorsQuantity) {
        List<Map<String, Object>> entidades = response.body().jsonPath().getList("$");

        assertEquals(professorsQuantity, entidades.size());
    }

    @When("solicito la lista de profesores con offset {int} y limit {int}")
    public void solicitoLaListaDeProfesoresConOffsetYLimit(int offset, int limit) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .queryParam("offset", offset)
                .queryParam("limit", limit)
                .when()
                .get("/professors");
    }
}
