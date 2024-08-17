package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;

import java.io.File;

import static steps.LoginUserSteps.token;

public class AddUsersSteps {
    Response responseNewUser;
    int statusCode;
    String idContact;
    @Step("#actor requested the add user service")
    public int addUser(File file) {
        responseNewUser = RestAssured.given().body(file)
                .auth().oauth2(token)
                .contentType("application/json")
                .when().post("/users")
                .then().statusCode(201)
                .extract().response();
        statusCode = responseNewUser.statusCode();
        return statusCode;
    }

    @Step("#actor should see the newly created user")
    public String idNewUser() {
        idContact = responseNewUser.jsonPath().getString("user._id");
        return idContact;
    }
}
