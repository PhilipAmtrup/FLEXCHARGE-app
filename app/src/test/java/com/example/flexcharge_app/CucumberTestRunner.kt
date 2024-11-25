package com.example.flexcharge_app

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/java/com/example/flexcharge_app/support_form.feature"], // Stien til din .feature-fil
    glue = ["com.example.flexcharge_app"], // Pakken hvor dine step definitions ligger
    plugin = ["pretty"] // For læsbar output
)
class CucumberTestRunner
