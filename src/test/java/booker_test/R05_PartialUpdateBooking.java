package booker_test;

import base_urls.BookerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.BookingPojo;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static booker_test.R02_CreateBooking.bookingId;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class R05_PartialUpdateBooking extends BookerBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    And
        {
            "firstname" : "Mary",
            "lastname" : "Star"
        }
    When
        Send PATCH request to the url
    Then
        Status code should be 200
    And
        Response body should be like:
        {
            "firstname" : "Mary",
            "lastname" : "Star",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Breakfast"
        }
     */

    @Test
    void partialUpdateBookingTest(){
        //Set the url
        spec.pathParams("first", "booking", "second", bookingId);

        //Set the expected Data
        String strJson = """
                      {
                            "firstname" : "Mary",
                            "lastname" : "Star"
                        }
                """;
        Map expectedData = ObjectMapperUtils.convertJsonToJava(strJson, Map.class);//In patch request Map payload is recommended.
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).patch("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        //Assert the fields you sent
        Map actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), Map.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.get("firstname"), expectedData.get("firstname"));
        assertEquals(actualData.get("lastname"), expectedData.get("lastname"));

        //If you want to assert whole body you can use hard codding.
        assertEquals(actualData.get("totalprice"), 111);
        //...


    }

}