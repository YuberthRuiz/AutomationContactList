package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import steps.AddContactsSteps;
import steps.LoginUserSteps;

import static org.junit.Assert.assertEquals;
import static steps.LoginUserSteps.token;

public class GetContactStepDefinitions {
    String idContacts;
    int statusCode;
    @Steps(shared = true)
    LoginUserSteps loginUserSteps;
    @Steps(shared = true)
    AddContactsSteps getContactsSteps;
    @When("^(.*) requested the contact service")
    public void user_requested_the_contact_service(String actor) {
        idContacts = getContactsSteps.idNewContact();
    }
    @Then("he should see the contact requested was successfully")
    public void user_should_see_the_contact_requested() {
        Response response = RestAssured.given()
                .auth().oauth2(token)
                .contentType("application/json")
                .when().get("/contacts/" + idContacts)
                .then().statusCode(200)
                .extract().response();
        String idContact = response.jsonPath().getString("_id");
        assertEquals(idContacts, idContact);
    }
}
