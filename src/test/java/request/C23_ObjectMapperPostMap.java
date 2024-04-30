package request;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C23_ObjectMapperPostMap extends JsonPlaceHolderBaseUrl {
/*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
               "userId": 55,
               "title": "Tidy your room",
               "completed": false
               }


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
    public void objectMapperMap() throws JsonProcessingException {
        //Set the url
        spec.pathParams("first", "todos");

        //Set the expected data
        String strJson = """
                {
                "userId": 55,
                "title": "Tidy your room",
                "completed": false
                }
                """; //We wil use this String Json to convert it to Pojo object

        Map expectedData = new ObjectMapper().readValue(strJson, Map.class);//This readValue method works with two parameters. First one is String formatted Json, second one is the data type you want to convert the json to.
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        Map actualData = new ObjectMapper().readValue(response.asString(), Map.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 201);
        assertEquals(actualData.get("userId"), expectedData.get("userId"));
        assertEquals(actualData.get("title"), expectedData.get("title"));
        assertEquals(actualData.get("completed"), expectedData.get("completed"));

    }

}