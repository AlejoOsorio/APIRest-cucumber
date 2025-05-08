package co.edu.uniquindio.ingesis;

import io.restassured.response.Response;

public class TestContext {
    private static TestContext instance;
    private Response response;

    private TestContext() {}

    public static synchronized TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return this.response;
    }
}