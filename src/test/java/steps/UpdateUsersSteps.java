package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;

import java.io.File;

import static steps.LoginUserSteps.token;

public class UpdateUsersSteps {
    @Step("#actor requested the update user service")
    public Response updateUser(File updateUserJson){
        File updateUser = new File(String.valueOf(updateUserJson));
        Response response = RestAssured.given().body(updateUser)
                .contentType("application/json")
                .auth().oauth2(token)
                .when().patch("/users/me")
                .then().statusCode(200)
                .extract().response();
        return response;
    }
}
