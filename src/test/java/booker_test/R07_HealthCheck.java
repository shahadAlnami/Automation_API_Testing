package booker_test;

import base_urls.BookerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class R07_HealthCheck extends BookerBaseUrl {
    /*

    Given
        https://restful-booker.herokuapp.com/ping
    When
        Send GET request to the url
    Then
        Status code should be 201
    And
        Response body should be: Created

     */

    @Test
    public void healthCheckTest(){

        //Set the url
        spec.pathParams("first","ping");

        //Set the expected data
        String expectedData = "Created";

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        assertEquals(response.statusCode(), 201);
        assertEquals(response.asString(), expectedData);

    }

}