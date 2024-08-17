package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import steps.AddUsersSteps;
import steps.LoginUserSteps;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static steps.LoginUserSteps.token;

public class GetProfileStepDefinitions {
    int statusCode;
    String idUser;
    Response response;
    @Steps(shared = true)
    LoginUserSteps loginUserSteps;

    @Steps(shared = true)
    AddUsersSteps addUsersSteps;
    @Given("^(.*) requested the profile service")
    public void sam_requested_the_profile_service(String user) {
        File addUser = new File("src/test/resources/json/addUser.json");
        response = RestAssured.given().body(addUser)
                .auth().oauth2(token)
                .contentType("application/json")
                .when().get("/users/me")
                .then().statusCode(200)
                .extract().response();
        statusCode = response.statusCode();
    }
    @Then("he should see the profile response successfully")
    public void user_should_see_the_profile_response() {
        assertEquals(statusCode, 200);
    }

}
