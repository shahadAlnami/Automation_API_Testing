package request;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import testData.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C14_PatchRequest extends JsonPlaceHolderBaseUrl {

    /*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
             "title": "Read Books"
           }
    When
        I send PATCH Request to the Url
    Then
       Status code is 200
       And response body is like  {
                                        "userId": 10,
                                        "id": 198,
                                        "title": "Read Books",
                                        "completed": true
                                    }
*/
    @Test
    public void patchRequestTest(){

        // set the url
        spec.pathParams("1","todos","2","198");

        // set the expected data
        Map<String,Object> expectedData = JsonPlaceHolderTestData.expectedDataMap(null,"Read Books",null);
        System.out.println("expectedData = " + expectedData);

        // send the request and get the response
        Response response = given(spec).body(expectedData).patch("{1}/{2}");

        //do assertion
        Map<String,Object> actualData = response.as(Map.class);
        assertEquals(response.statusCode(),200);
        assertEquals(actualData.get("title"),expectedData.get("title"));
    }
}
