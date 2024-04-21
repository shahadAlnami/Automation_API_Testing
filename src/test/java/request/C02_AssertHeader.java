package request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class C02_AssertHeader {
    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
    And
        Connection should be keep-alive
*/
    @Test
    public void asserHeaderMethod(){

        /** 1. User sends a GET Request to the url **/
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        //response.prettyPrint();

        /** 2. HTTP Status Code should be 200 **/
        response.then().statusCode(200);

        /** 3. Content Type should be JSON **/
        response.then().contentType("application/json");

        /** 4.Status Line should be HTTP/1.1 200 OK **/
        response.then().statusLine("HTTP/1.1 200 OK");

        /** 5. Connection should be keep-alive **/
        response.then().header("Connection","keep-alive");

    }
}
