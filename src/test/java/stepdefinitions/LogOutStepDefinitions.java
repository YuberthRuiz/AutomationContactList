package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import steps.LoginUserSteps;

import static org.junit.Assert.assertEquals;
import static steps.LoginUserSteps.token;

public class LogOutStepDefinitions {
    int statusCode;
    Response response;
    @Steps(shared = true)
    LoginUserSteps loginUserSteps;
    @When("Sam requested the logout service")
    public void user_requested_the_logout_service() {
        response = RestAssured.given()
                .auth().oauth2(token)
                .contentType("application/json")
                .when().post("/users/logout")
                .then().statusCode(200)
                .extract().response();
        statusCode = response.getStatusCode();
    }

    @Then("he should exit the app")
    public void user_should_exit_the_app() {
        assertEquals(statusCode, 200);
    }
}
