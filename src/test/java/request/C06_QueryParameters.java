package request;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;

public class C06_QueryParameters {
    /*
    Given
       https://restful-booker.herokuapp.com/booking
    When
       User sends a GET request to the URL
    Then
       Status code is 200
    And
       Among the data, there should be someone whose first name is "Jane" and last name is "Doe"
*/

    @Test
    public void queryParametersTest() {

//        1. Set the URL
        String url = "https://restful-booker.herokuapp.com/booking?firstname=Jane&lastname=Doe";

//        2. Set the expected data

//        3. Send the request and get the response
        Response response = given().get(url);
//        response.prettyPrint();

//        4. Do Assertion
        response.then().statusCode(200);

        //1st way:
        Assert.assertTrue(response.asString().contains("bookingid")); // check if the response contain at least one booking ID

        //2nd way:
        //response.then().body("", hasSize(greaterThan(0)));//This means to check if it has at least one booking id

    }
}
