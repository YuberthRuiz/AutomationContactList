package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import steps.AddContactsSteps;
import steps.LoginUserSteps;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CreateContactStepDefinitions {
    int statusCode;
    String idContact;
    Response responseNewContact;
    @Before
    public void setupBaseUrl(){
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
    }
    @Steps(shared = true)
    LoginUserSteps loginUserSteps;

    @Steps(shared = true)
    AddContactsSteps getContactsSteps;

    @Given("^(.*) is logged into the application")
    public void user_is_logged_in_the_application(String actor) {
        File login = new File("src/test/resources/json/loginUser.json");
        loginUserSteps.getToken(login);
    }

    @When("^(.*) requested the add contact service")
    public void user_requested_the_add_contact_service(String user) {
        statusCode = getContactsSteps.addContact(user);
    }

    @Then("he should see the contact created successfully")
    public void user_should_see_the_new_created_contact() {
        idContact = getContactsSteps.idNewContact();
        assertNotNull(idContact);
        assertEquals(statusCode, 201);
    }

}
