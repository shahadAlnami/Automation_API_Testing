package booker_test;

import base_urls.BookerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class R01_GetBookingIds extends BookerBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        Send GET request to the url
    Then
        Assert that status code is 200
    And
        Response body should have more than 0 elements
     */

    @Test
    void getBookingIdsTest(){
        //Set the url
        spec.pathParams("first","booking");

        //Set the expected data
        //We don't have any specific body to assert

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        response
                .then()
                .statusCode(200)
                .body("", hasSize(greaterThan(0)));

    }



}
