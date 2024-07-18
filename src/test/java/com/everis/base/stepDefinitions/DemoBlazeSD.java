package com.everis.base.stepDefinitions;

import com.everis.base.service.DemoBlazeService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.nio.file.Files;
import java.nio.file.Paths;
import net.thucydides.core.annotations.Steps;
import org.jruby.RubyProcess;

public class DemoBlazeSD {

    @Steps
    public DemoBlazeService demoblaze;


    @Given("que la aplicación esta funcionando")
    public void queLaAplicaciónEstaFuncionando() {
    }

    @And("inicializo un post en signup")
    public void inicializoUnPostEnSignup() {
        demoblaze.incializoParametrosRequestPost();
    }

    @And("ejecuto la creacion de \"([^\"]*)\"$")
    public void ejecutoLaCreacionDe(String api) {
        demoblaze.sendPostRequest(api);
    }
    @Then("valido que la respuesta es {int}")
    public void validoQueLaRespuestaEs(int i) {
        demoblaze.validarStatusCode(i);
    }


    @And("^agregar la cabecera key: \"([^\"]*)\", y valor: \"([^\"]*)\"$")
    public void agregarLaCabeceraKeyYValor(String k, String v) {
        demoblaze.setHeader(k, v);
    }

    @And("valido la creacion del usuario")
    public void validoLaCreacionDelUsuario() {
        demoblaze.validarCracionUsuario();
    }

    @And("inicializo un post en login")
    public void inicializoUnPostEnLogin() {
        demoblaze.incializoParametrosRequestPost();
    }

    @And("inicio sesion con el username {string} y password {string}")
    public void inicioSesionConElUsernameYPassword(String user, String pass) {
        demoblaze.inicarSesion(user,pass);
    }

    @And("ejecuto el \"([^\"]*)\"$")
    public void ejecutoEl(String api) {
        demoblaze.sendPostRequest(api);
    }

    @And("valido que el usuario se a logiado")
    public void validoQueElUsuarioSeALogiado() {
        demoblaze.validarEstadoLogeo();
    }


    @And("creo un nuevo usuario desde el indice {int} del archivo {string}")
    public void creoUnNuevoUsuarioDesdeElIndiceDelArchivo(int index, String jsonFile)  {
        try {

            String jsonContent = new String(Files.readAllBytes(Paths.get("src/test/resources/" + jsonFile)));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode ruta = objectMapper.readTree(jsonContent);
            JsonNode indexJson = ruta.get("examples").get(index);
            String user = indexJson.get("user").asText();
            String pass = indexJson.get("pass").asText();
            demoblaze.crearUsuario(user,pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("inicio sesion desde el indice {int} del archivo {string}")
    public void inicioSesionDesdeElIndiceDelArchivo(int index,String json) {
        try {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/test/resources/" + json)));
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode ruta = objectMapper.readTree(jsonContent);
            JsonNode indexJson = ruta.get("examples").get(index);
            String user = indexJson.get("user").asText();
            String pass = indexJson.get("pass").asText();

            demoblaze.inicarSesion(user,pass);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
