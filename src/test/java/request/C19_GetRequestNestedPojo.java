package request;

import base_urls.BookerBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.BookingDatesPojo;
import pojo.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C19_GetRequestNestedPojo extends BookerBaseUrl {
/*
        Given
            https://restful-booker.herokuapp.com/booking/466
        When
            I send GET Request to the url
        Then
            Status code should be 200
            Response body should be like that;
            {
                "firstname": "Jane",
                "lastname": "Doe",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Extra pillows please"
            }
*/

    @Test
    public void getRequestPojoTest() {
        //Set the url
        // --> You can declare the parameters in request as well

        //Set the expected data
        //Start with inner pojo
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Jane", "Doe", 111, true, bookingDatesPojo, "Extra pillows please");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("booking/41");//Parameters can be declared directly here
        response.prettyPrint();

        //Do assertion
        BookingPojo actualData = response.as(BookingPojo.class);//De-Serialization can not be done without default constructor in corresponding Pojo class
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getFirstname(), expectedData.getFirstname());
        assertEquals(actualData.getLastname(), expectedData.getLastname());
        assertEquals(actualData.getTotalprice(), expectedData.getTotalprice());
        assertEquals(actualData.getDepositpaid(), expectedData.getDepositpaid());
        assertEquals(actualData.getBookingdates().getCheckin(), bookingDatesPojo.getCheckin());
        assertEquals(actualData.getBookingdates().getCheckout(), bookingDatesPojo.getCheckout());
        assertEquals(actualData.getAdditionalneeds(), expectedData.getAdditionalneeds());

    }

}