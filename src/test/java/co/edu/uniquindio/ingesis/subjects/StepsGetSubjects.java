package co.edu.uniquindio.ingesis.subjects;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsGetSubjects {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("existen {int} o mas materias")
    public void existenOMasMaterias(int subjectsCount) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .get("/subjects");

        List<Map<String, Object>> subjects = response.body().jsonPath().getList("$");

        if (subjects.size() < subjectsCount) {
            int iterations = subjectsCount - subjects.size();

            for (int i = 0; i <= iterations; i++) {
                HashMap<Object, Object> datos = new HashMap<>();
                datos.put("name", "subject" + i);
                datos.put("description", "description" + i);
                datos.put("credits", 3);

                response = given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(datos)
                        .when()
                        .post("/subjects");
            }
        }

        context.setResponse(response);
    }

    @When("consulto la lista de materias sin especificar offset ni limit")
    public void consultoLaListaDeMateriasSinEspecificarOffsetNiLimit() {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .get("/subjects");

        context.setResponse(response);
    }

    @When("consulto la lista de materias con offset {int} y limit {int}")
    public void consultoLaListaDeMateriasConOffsetYLimit(int offset, int limit) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .queryParam("offset", offset)
                .queryParam("limit", limit)
                .when()
                .get("/subjects");

        context.setResponse(response);
    }
}
