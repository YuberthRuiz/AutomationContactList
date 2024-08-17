package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import steps.AddContactsSteps;

import static org.junit.Assert.assertEquals;
import static steps.LoginUserSteps.token;

public class DeleteContactStepDefinitions {
    Response response;
    int statusCode;
    @Steps(shared = true)
    AddContactsSteps getContactsSteps;
    @When("Sam try to delete the contact")
    public void user_try_to_delete_the_contact() {
        String idContact = getContactsSteps.idNewContact();
        response = RestAssured.given()
                .auth().oauth2(token)
                .contentType("application/json")
                .when().delete("/contacts/" + idContact)
                .then().statusCode(200)
                .extract().response();
        statusCode = response.getStatusCode();
    }

    @Then("he should see the contact was deleted")
    public void he_should_see_the_contact_was_deleted() {
        assertEquals(statusCode, 200);
    }
}
