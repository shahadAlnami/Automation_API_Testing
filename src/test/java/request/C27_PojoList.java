package request;

import base_urls.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.JsonPlaceHolderPojo;
import utilities.ObjectMapperUtils;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class C27_PojoList extends JsonPlaceHolderBaseUrl {
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
    void pojoListTest() {
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
        List<JsonPlaceHolderPojo> actualDataList = response.as(new TypeRef<>() {
        });
        System.out.println("actualDataList = " + actualDataList);

        int idx = 0;
        for (JsonPlaceHolderPojo eachPojo : actualDataList) {

            if (eachPojo.getTitle().equals(expectedData.getTitle())) {
                break;
            }
            idx++;
        }

        System.out.println("idx = " + idx);
        JsonPlaceHolderPojo actualData = actualDataList.get(idx);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getUserId(), expectedData.getUserId());
        assertEquals(actualData.getTitle(), expectedData.getTitle());
        assertEquals(actualData.getCompleted(), expectedData.getCompleted());

    }

}
