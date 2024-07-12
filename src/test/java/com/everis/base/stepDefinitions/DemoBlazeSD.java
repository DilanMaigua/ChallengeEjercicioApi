package com.everis.base.stepDefinitions;

import com.everis.base.service.DemoBlazeService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

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

    @And("creo un nuevo usuario con username {string} y password {string}")
    public void creoUnNuevoUsuarioConUsernameYPassword(String arg0, String arg1) {
        demoblaze.crearUsuario(arg0,arg1);
    }

    @And("ejecuto la creacion de \"([^\"]*)\"$")
    public void ejecutoLaCreacionDe(String api) {
        demoblaze.sendPostRequest(api);
    }
    @Then("valido que la respuesta es {int}")
    public void validoQueLaRespuestaEs(int i) {
        demoblaze.validarStatusCode(i);
    }

    @And("se valida el {string} sea {string}")
    public void seValidaElSea(String arg0, String arg1) {
        demoblaze.validarDataResponse(arg0,arg1);
    }


    @And("^agregar la cabecera key: \"([^\"]*)\", y valor: \"([^\"]*)\"$")
    public void agregarLaCabeceraKeyYValor(String k, String v) {
        demoblaze.setHeader(k, v);
    }

    @And("valido la creacion del usuario")
    public void validoLaCreacionDelUsuario() {
        demoblaze.validarCracionUsuario();
    }
}
