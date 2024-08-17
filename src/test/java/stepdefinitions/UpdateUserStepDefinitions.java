package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import steps.UpdateUsersSteps;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class UpdateUserStepDefinitions {

    int statusCode;
    Response response;
    File updateUser;

    @Steps(shared = true)
    UpdateUsersSteps updateUsersSteps;

    @When("^(.*) requested the update user service")
    public int user_requested_the_update_user_service(String actor) {
        updateUser = new File("src/test/resources/json/updateUser.json");
        response = updateUsersSteps.updateUser(updateUser);
        statusCode = response.getStatusCode();
        return statusCode;
    }
    @Then("he should see the updated user successfully response")
    public void user_should_see_the_updated_user() {
        assertEquals(statusCode, 200);
        updateUser = new File("src/test/resources/json/updateRestoreUser.json");
        response = updateUsersSteps.updateUser(updateUser);
        System.out.println(response.jsonPath().getString("email"));
    }
}
