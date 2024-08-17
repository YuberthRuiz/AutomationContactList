package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import steps.AddUsersSteps;
import steps.DeleteUsersSteps;
import steps.LoginUserSteps;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CreateUserStepDefinitions {
    int statusCode;
    String idUser;
    @Steps(shared = true)
    LoginUserSteps loginUserSteps;

    @Steps(shared = true)
    DeleteUsersSteps deleteUsersSteps;

    @Steps(shared = true)
    AddUsersSteps addUsersSteps;
    @When("he requested the add user service")
    public void user_requested_the_add_user_service() {
        File userAlternative = new File("src/test/resources/json/AddAlternativeUser.json");
        statusCode = addUsersSteps.addUser(userAlternative);
    }
    @Then("he should see user created successfully")
    public void user_should_see_the_newly_created_user() {
        idUser = addUsersSteps.idNewUser();
        assertNotNull(idUser);
        assertEquals(statusCode, 201);
        File loginAlternative = new File("src/test/resources/json/loginAlternativeUser2.json");
        loginUserSteps.getToken(loginAlternative);
        deleteUsersSteps.deleteUser();
    }
}
