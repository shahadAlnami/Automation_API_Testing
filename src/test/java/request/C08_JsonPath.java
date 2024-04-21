package request;

import base_urls.BookerBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C08_JsonPath extends BookerBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/32
    When
        User send a GET request to the URL
    Then
        HTTP Status Code should be 200
    And
        Response content type is "application/json"
    And
        Response body should be like;
        {
            "firstname": "Josh",
            "lastname": "Allen",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            },
            "additionalneeds": "super bowls"
        }
*/

    @Test
    public void jsonPathTest() {
        spec.pathParams("first","booking","second","34");
        Response response =given(spec).get("{first}/{second}");
        response.prettyPrint();

        //2nd way: By extracting data outside the body with JSONPath
        //Convert Response to JsonPath object
        JsonPath jsonPath = response.jsonPath();

        //Retrieve the desired data by using JsonPath object
        String firstname = jsonPath.getString("firstname");
        String lastname = jsonPath.getString("lastname");
        int totalprice = jsonPath.getInt("totalprice");
        boolean depositpaid = jsonPath.getBoolean("depositpaid");
        String checkin = jsonPath.getString("bookingdates.checkin");
        String checkout = jsonPath.getString("bookingdates.checkout");
        String additionalneeds = jsonPath.getString("additionalneeds");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(firstname, "Josh");//If this assertion fails, the subsequent lines will execute as well. Because this is Soft Assertion.
        softAssert.assertEquals(lastname, "Allen");
        softAssert.assertEquals(totalprice, 111);
        softAssert.assertTrue(depositpaid);
        softAssert.assertEquals(checkin, "2018-01-01");
        softAssert.assertEquals(checkout, "2019-01-01");
        softAssert.assertEquals(additionalneeds, "super bowls");
        softAssert.assertAll();//In any failure case execution will stop here in soft assertion

        //Not: Hard assertion is used commonly in market. Because if any failure occurs we must fix it immediately.

    }
}
