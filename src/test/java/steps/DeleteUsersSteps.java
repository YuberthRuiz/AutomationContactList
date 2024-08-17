package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static steps.LoginUserSteps.token;

public class DeleteUsersSteps {
    public Response deleteUser(){
        Response response = RestAssured.given()
                .contentType("application/json")
                .auth().oauth2(token)
                .when().delete("/users/me")
                .then().statusCode(200)
                .extract().response();
        if(response.getStatusCode() != 200)
            System.out.println(response.jsonPath().getString("message"));
        return response;
    }
}
