package com.example.flexcharge_app

import io.cucumber.java.en.Given
import io.cucumber.java.en.When
import io.cucumber.java.en.Then
import junit.framework.TestCase.assertEquals


class SupportFormSteps {

    private var email: String = ""
    private var phoneNumber: String = ""
    private var problemDescription: String = ""
    private var resultMessage: String? = null

    @Given("I am on the support form page")
    fun i_am_on_the_support_form_page() {
        // Simuler, at brugeren er på supportformular-siden
        email = ""
        phoneNumber = ""
        problemDescription = ""
        resultMessage = null
    }

    @When("I enter a valid email {string}")
    fun i_enter_a_valid_email(input: String) {
        email = input
    }

    @When("I enter a valid phone number {string}")
    fun i_enter_a_valid_phone_number(input: String) {
        phoneNumber = input
    }

    @When("I enter a valid problem description {string}")
    fun i_enter_a_valid_problem_description(input: String) {
        problemDescription = input
    }

    @When("I leave the email field blank")
    fun i_leave_the_email_field_blank() {
        email = ""
    }

    @When("I leave the problem description blank")
    fun i_leave_the_problem_description_blank() {
        problemDescription = ""
    }

    @When("I click the submit button")
    fun i_click_the_submit_button() {
        resultMessage = validateAndSubmit(email, phoneNumber, problemDescription)
    }

    @Then("I should see a success message {string}")
    fun i_should_see_a_success_message(expectedMessage: String) {
        assertEquals(expectedMessage, resultMessage)
    }

    @Then("I should see an error message {string}")
    fun i_should_see_an_error_message(expectedMessage: String) {
        assertEquals(expectedMessage, resultMessage)
    }

    private fun validateAndSubmit(email: String, phoneNumber: String, problemDescription: String): String {
        return when {
            email.isBlank() -> "Email cannot be empty."
            problemDescription.isBlank() -> "Problem description cannot be empty."
            else -> "Your support request was submitted successfully!"
        }
    }
}
