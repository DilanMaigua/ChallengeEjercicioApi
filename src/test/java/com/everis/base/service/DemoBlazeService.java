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
import org.json.JSONObject;

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

    public void inicarSesion(String user, String pass) {
        JsonObject parametros = new JsonObject();
        parametros.addProperty("username", user);
        parametros.addProperty("password", pass);
        bodyPost = parametros.toString();
        builder.setBody(bodyPost);
    }

    public void validarEstadoLogeo() {
        String responseBody = response.getBody().asString();
        LOGGER.info("Response body logeo:" + responseBody);

        responseBody = responseBody.replace("\"", "");

        response.then().assertThat().statusCode(200);

        if (responseBody.startsWith("{")) {
            JSONObject jsonResponse = new JSONObject(responseBody);
            String errorMessage = jsonResponse.optString("errorMessage");

            if ("Wrong password.".equals(errorMessage)) {
                throw new AssertionError("Contraseña incorrecta.");
            } else if ("User does not exist.".equals(errorMessage)) {
                throw new AssertionError("El usuario no existe.");
            } else {
                throw new AssertionError("Error desconocido: " + errorMessage);
            }
        } else if (responseBody.startsWith("Auth_token:")) {
            LOGGER.info("Usuario se ha logeado con exito");
        }
    }
}
