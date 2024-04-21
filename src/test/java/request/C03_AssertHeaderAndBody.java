package request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C03_AssertHeaderAndBody {

    /*
   Given
       https://restful-booker.herokuapp.com/booking/0
   When
       User sends a GET Request to the URL
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "Clarusway"
   And
       Server is "Cowboy"
*/

    /** 1. User sends a GET Request to the URL **/
    Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking/0");

    @Test
    public void ShortAssertionTest(){
        /** we can use this to test just in one line ( 2,3,6 )**/
        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found").header("Server","Cowboy");

        /** 4,5 **/
        String body = response.body().asString();
        Assert.assertTrue(body.contains("Not Found") & !body.contains("SDA"));
    }

    @Test
    public void longAssertionMethod(){

        /** 2. HTTP Status code should be 404 **/
        int statusCode =  response.statusCode();
        Assert.assertEquals(statusCode,404);

        /** 3. Status Line should be HTTP/1.1 404 Not Found **/
        String statusLine = response.statusLine();
        Assert.assertEquals(statusLine,"HTTP/1.1 404 Not Found");

        /** 4. Response body contains "Not Found" **/
        String body = response.body().asString();
        Assert.assertTrue(body.contains("Not Found"));

        /** 5. Response body does not contain "SDA" **/
        Assert.assertFalse(body.contains("SDA"));

        /** 6. Server is "Cowboy" **/
        String server = response.header("Server");
        Assert.assertEquals(server,"Cowboy");
    }
}
