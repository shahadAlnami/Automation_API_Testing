package request;

import base_urls.BookerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testData.BookerTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C17_GetRequestMap extends BookerBaseUrl {

    /*
    Given
        https://restful-booker.herokuapp.com/booking/827
    When
        I send GET Request to the url
    Then
        Response body should be like that;
            {
                "firstname": "John",
                "lastname": "Smith",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Breakfast"
            }
 */

    @Test
    public void getRequestMap(){

        //Set the url
        spec.pathParams("first", "booking", "second", "16");

        //Set the expected data
        //We set the expected data to use it in assertion
        Map<String, String> bookingDates = BookerTestData.bookingdatesMethod("2018-01-01", "2019-01-01");
        Map<String, Object> expectedData = BookerTestData.expectedDataMethod("John", "Smith", 111, true, bookingDates, "Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String, Object> actualData = response.as(Map.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.get("firstname"), expectedData.get("firstname"));
        assertEquals(actualData.get("lastname"), expectedData.get("lastname"));
        assertEquals(actualData.get("totalprice"), expectedData.get("totalprice"));
        assertEquals(actualData.get("depositpaid"), expectedData.get("depositpaid"));
        assertEquals(((Map) actualData.get("bookingdates")).get("checkin"), bookingDates.get("checkin"));
        assertEquals(((Map) actualData.get("bookingdates")).get("checkout"), bookingDates.get("checkout"));
        assertEquals(actualData.get("additionalneeds"), expectedData.get("additionalneeds"));

    }
}
