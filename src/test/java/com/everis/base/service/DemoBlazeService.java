package com.everis.base.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.thucydides.core.annotations.Step;
import org.hamcrest.CoreMatchers;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class DemoBlazeService {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DemoBlazeService.class);
    static private final String BASE_URL = "https://api.demoblaze.com/";


    private static RequestSpecification requestSpec;
    private static ResponseSpecification responseSpec;

    private Response response;
    private RequestSpecBuilder builder;
    private RequestSpecification requestSpecification;
    private String bodyPost;

    @Before
    public void init() {

        LOGGER.info(" Inicializa el constructor request ");
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .build();

        LOGGER.info(" Inicializa el constructor response ");
        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @Step("set Service Name")
    public void incializoParametrosRequestPost() {
        RestAssured.baseURI = BASE_URL;
        builder = new RequestSpecBuilder();
        requestSpecification = builder.build();
    }

    public void crearUsuario(String user,String pass) {
        JsonObject parametros = new JsonObject();
        parametros.addProperty("username", user);
        parametros.addProperty("password", pass);

        bodyPost = parametros.toString();

        builder.setBody(bodyPost);
    }

    public void sendPostRequest(String api) {
        response = given().spec(requestSpecification).when().post(api);
    }

    public void validarStatusCode(int i) {
        assertThat(lastResponse().statusCode(), is(i));
    }



    @Step("set Header")
    public void setHeader(String k, String v) {
        builder.addHeader(k, v);
    }

    public void validarDataResponse(String arg0, String arg1) {
        assertThat(response.body().path(arg0), CoreMatchers.equalTo(arg1));
    }

    public void validarCracionUsuario() {
        String responseBody = response.getBody().asString();
        LOGGER.info("Response body:" + responseBody);

        response.then().assertThat().statusCode(200);

        if (responseBody.contains("errorMessage")) {
            throw new AssertionError("El usuario ya existe.");
        } else {
            LOGGER.info("Usuario creado con éxito.");
        }
    }
}
