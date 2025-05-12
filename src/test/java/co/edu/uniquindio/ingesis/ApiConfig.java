package co.edu.uniquindio.ingesis;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

public class ApiConfig {
    public static final RequestSpecification BASE_REQUEST = new RequestSpecBuilder()
            .setBaseUri("http://localhost:8100")
            .setContentType(ContentType.JSON)
            .build();
}
