package com.everis.base.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features",
        glue = "com.everis.base",
        plugin = {"html:target/cucumber-reports"},
        tags = "@PruebasDemoblazeApi", // => Se puede especificar qué Ejecutar
        strict = true)
public class baseTest {

}
