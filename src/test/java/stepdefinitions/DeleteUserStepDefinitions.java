package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Steps;
import steps.AddUsersSteps;
import steps.DeleteUsersSteps;
import steps.LoginUserSteps;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class DeleteUserStepDefinitions {

    int statusCode;
    Response response;
    @Steps(shared = true)
    LoginUserSteps loginUserSteps;

    @Steps(shared = true)
    DeleteUsersSteps deleteUsersSteps;

    @Steps(shared = true)
    AddUsersSteps addUsersSteps;

    @When("Sam requested the delete user service")
    public int user_requested_the_delete_user_service() {
        response = deleteUsersSteps.deleteUser();
        statusCode = response.getStatusCode();
        return statusCode;
    }
    @Then("he should see the user was deleted successfully")
    public void user_should_see_the_user_was_deleted_successfully() {
        assertEquals(statusCode, 200);
        File loginAlternativeUser = new File("src/test/resources/json/loginAlternativeUser.json");
        loginUserSteps.getToken(loginAlternativeUser);
        File user = new File("src/test/resources/json/AddUser.json");
        addUsersSteps.addUser(user);
    }
}
