package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import steps.LoginUserSteps;

import static org.junit.Assert.assertEquals;
import static steps.LoginUserSteps.token;

public class GetContactListStepDefinitions {

    int statusCode;
    @Steps(shared = true)
    LoginUserSteps loginUserSteps;
    CreateContactStepDefinitions createContactStepDefinitions;
    @When("^(.*) requested the list of contacts")
    public void user_requested_the_list_of_contacts( String actor) {
        Response response = RestAssured.given()
                .auth().oauth2(token)
                .contentType("application/json")
                .when().get("/contacts")
                .then().statusCode(200)
                .extract().response();
        statusCode = response.getStatusCode();
    }
    @Then("he should see a successfully request response")
    public void user_should_see_the_created_contacts() {
        assertEquals(statusCode, 200);
    }
}
