package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static steps.LoginUserSteps.token;

public class AddContactsSteps {
    int statusCode;
    String idContact;
    Response responseNewContact;

    @Steps(shared = true)
    LoginUserSteps loginUserSteps;
    @Step("#actor requested the add contact service")
    public int addContact(String user) {
        File addContact = new File("src/test/resources/json/addContact.json");
        responseNewContact = RestAssured.given().body(addContact)
                .auth().oauth2(token)
                .contentType("application/json")
                .when().post("/contacts")
                .then().statusCode(201)
                .extract().response();
        statusCode = responseNewContact.statusCode();
        return statusCode;
    }

    @Step("#actor should see the newly created contact")
    public String idNewContact() {
        idContact = responseNewContact.jsonPath().getString("_id");
        return idContact;
    }
}
