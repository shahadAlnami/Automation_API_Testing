package request;

import base_urls.JsonPlaceHolderBaseUrl;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class C21_DeleteRequest extends JsonPlaceHolderBaseUrl {

/*
    Given
        https://jsonplaceholder.typicode.com/todos/198
    When
        I send DELETE Request to the Url
    Then
        Status code is 200
        And Response body is { }
*/

    @Test
    public void deleteRequestTest(){

        //Set the url
        spec.pathParams("1","todos","2","198");

        //send the request and get the response
        Response response = given(spec).delete("{1}/{2}");
        response.prettyPrint();

        //Do assertion
        Map<Object,Object> actualData = response.as(Map.class); // we created this just to assert the body
        System.out.println("actualData = " + actualData);
        assertEquals(response.statusCode(),200);
        assertTrue(actualData.isEmpty());
    }

}
