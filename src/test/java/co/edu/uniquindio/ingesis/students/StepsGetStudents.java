package co.edu.uniquindio.ingesis.students;

import co.edu.uniquindio.ingesis.ApiConfig;
import co.edu.uniquindio.ingesis.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class StepsGetStudents {

    private final TestContext context = TestContext.getInstance();
    private Response response = context.getResponse();

    @Given("Existen {int} o mas estudiantes registrados en el sistema")
    public void existenOMasEstudiantesRegistradosEnElSistema(int studentsCount) {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .when()
                .get("/students");


        List<Map<String, Object>> students = response.body().jsonPath().getList("$");

        if (students.size() < studentsCount) {
            int iterations = studentsCount - students.size();

            for (int i = 0; i <= iterations; i++) {
                HashMap<Object, Object> datos = new HashMap<>();
                datos.put("name", "student" + i);
                datos.put("lastName", "lastname" + i);
                datos.put("identification", String.valueOf(91828272 + i));
                datos.put("email", "email" + i + "@gmail.com");
                datos.put("birthDate", "1958-08-29");
                datos.put("phoneNumber", String.valueOf(1003004050 + i));

                response = given()
                        .spec(ApiConfig.BASE_REQUEST)
                        .body(datos)
                        .when()
                        .post("/students");
            }
        }

        context.setResponse(response);
    }

    @When("consulto la lista de estudiantes con parámetros de paginación válidos")
    public void consultoLaListaDeEstudiantesConParámetrosDePaginaciónVálidos() {
        response = given()
                .spec(ApiConfig.BASE_REQUEST)
                .queryParam("offset", 0)
                .queryParam("limit", 20)
                .when()
                .get("/students");
        context.setResponse(response);
    }
}
