package steps;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;

import java.io.File;

public class LoginUserSteps {
    public static String token;
    @Before
    public void setupBaseUrl(){
        RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
    }
    @Step("#actor is logged into the application")
    public void getToken(File file){
        Response response = RestAssured.given().body(file)
                .contentType("application/json")
                .when().post("/users/login")
                .then().statusCode(200)
                .extract().response();
        token = response.jsonPath().getString("token");
        if(response.getStatusCode() != 200)
            System.out.println(response.jsonPath().getString("message"));
    }
}
