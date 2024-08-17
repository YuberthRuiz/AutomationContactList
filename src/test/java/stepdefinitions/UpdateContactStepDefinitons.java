package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import steps.AddContactsSteps;
import steps.LoginUserSteps;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static steps.LoginUserSteps.token;

public class UpdateContactStepDefinitons {
    Response response;
    int statusCode;
    @Steps(shared = true)
    LoginUserSteps loginUserSteps;
    @Steps(shared = true)
    AddContactsSteps getContactsSteps;
    @When("Sam try to update the contact")
    public void user_try_to_update_the_contact() {
        String idContact = getContactsSteps.idNewContact();
        File updateContact = new File("src/test/resources/json/updateContact.json");
        response = RestAssured.given().body(updateContact)
                .auth().oauth2(token)
                .contentType("application/json")
                .when().put("/contacts/" + idContact)
                .then().statusCode(200)
                .extract().response();
        statusCode = response.getStatusCode();
    }
    @When("Sam try to update just one attribute of the contact")
    public void user_try_to_update_just_one_attribute_of_the_contact() {
        String idContact = getContactsSteps.idNewContact();
        File updateContactAttribute = new File("src/test/resources/json/updateAttributeContact.json");
        response = RestAssured.given().body(updateContactAttribute)
                .auth().oauth2(token)
                .contentType("application/json")
                .when().patch("/contacts/" + idContact)
                .then().statusCode(200)
                .extract().response();
        statusCode = response.getStatusCode();

    }
    @Then("he should see a successfully response")
    public void user_should_see_the_contact_updated() {
        assertEquals(statusCode, 200);
    }
}
