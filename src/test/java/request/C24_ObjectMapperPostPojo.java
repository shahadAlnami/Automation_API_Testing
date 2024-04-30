package request;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;

import java.util.Objects;

import static io.restassured.RestAssured.given;

public class C24_ObjectMapperPostPojo extends JsonPlaceHolderBaseUrl {
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
    public void objectMapperPostPojoTest() throws JsonProcessingException {
        //Set the url
        spec.pathParams("first", "todos");

        //Set the expected data
        String strJson = """
                {
                    "userId": 55,
                    "title": "Tidy your room",
                    "completed": false
                }
                """;

        JsonPlaceHolderPojo expectedData = new ObjectMapper().readValue(strJson, JsonPlaceHolderPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).body(expectedData).post("{first}");
        response.prettyPrint();

        //Do assertion
        JsonPlaceHolderPojo actualData = new ObjectMapper().readValue(response.asString(), JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assert response.statusCode()==201 : "Status code did not match";//This is Java assertion
        assert actualData.getUserId()==expectedData.getUserId() : "userId did not match";
        assert Objects.equals(actualData.getTitle(), expectedData.getTitle()) : "title did not match";
        assert actualData.getCompleted()==expectedData.getCompleted() : "completed did not match";


    }

}