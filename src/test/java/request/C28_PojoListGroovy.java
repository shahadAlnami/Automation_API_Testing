package request;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class C28_PojoListGroovy extends JsonPlaceHolderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
            I send a GET request to the Url
        Then
            HTTP Status Code should be 200
        And
            There must be a todo like:
                {
                    "userId": 1,
                    "id": 4,
                    "title": "et porro tempora",
                    "completed": true
                }
     */
    @Test
    void pojoListTest() throws JsonProcessingException {
        //Set the url
        spec.pathParams("first", "todos");

        //Set the expected data
        String strJson = """
                {
                    "userId": 1,
                    "id": 4,
                    "title": "et porro tempora",
                    "completed": true
                }
                """;

        JsonPlaceHolderPojo expectedData = convertJsonToJava(strJson, JsonPlaceHolderPojo.class);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}");
        response.prettyPrint();

        //Do assertion
        Object actualDataObject = response.jsonPath().getList("findAll{it.title=='et porro tempora'}").getFirst();//getList() method takes the elements as Object
        System.out.println("actualDataObject = " + actualDataObject);
        String actualDataString = new ObjectMapper().writeValueAsString(actualDataObject);//Since the element in Object type we need to convert it to String via writeValueAsString() method.
        System.out.println("actualDataString = " + actualDataString);

        JsonPlaceHolderPojo actualData = ObjectMapperUtils.convertJsonToJava(actualDataString, JsonPlaceHolderPojo.class);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getUserId(), expectedData.getUserId());
        assertEquals(actualData.getTitle(), expectedData.getTitle());
        assertEquals(actualData.getCompleted(), expectedData.getCompleted());

    }

}
