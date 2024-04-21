package request;

import base_urls.JsonPlaceHolderBaseUrl;
import org.testng.annotations.Test;
import pojo.JsonPlaceHolderPojo;

public class C18_PostRequestPojo extends JsonPlaceHolderBaseUrl {

/*
     Given
        https://jsonplaceholder.typicode.com/todos
        {
        "userId": 55,
        "title": "Tidy your room",
        "completed": false
        }
    When
        I send POST Request to the Url
    Then
        Status code is 201
    And
        response body is like {
                                "userId": 55,
                                "title": "Tidy your room",
                                "completed": false,
                                "id": 201
                                }
*/

    @Test
    public void postRequestPojoTest(){
        //Set the url
        spec.pathParams("first","todos");

        //Set the expected data --> With Pojo Class
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);




    }
}
