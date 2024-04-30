package petstore_pet;

import base_urls.PetStoreBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static petstore_pet.R01_CreatePet.petId;
import static utilities.ObjectMapperUtils.convertJsonToJava;

public class R02_GetPet extends PetStoreBaseUrl {
/*
     Given
       https://petstore.swagger.io/v2/pet/:id

    When
        I send GET Request to the Url

    Then
        Status code is 200
    And
        response body is like {
                          "id": 98765432,
                          "category": {
                            "id": 0,
                            "name": "Cat"
                          },
                          "name": "Cotton",
                          "photoUrls": [
                            "string"
                          ],
                          "tags": [
                            {
                              "id": 0,
                              "name": "Kitty"
                            }
                          ],
                          "status": "available"
                        }
*/

    @Test
    void postTest(){
        //Set the url
        spec.pathParams("first","pet", "second", petId);


        //Set the expected data
        String strJson = """
                        {
                     
                          "category": {
                            "id": 0,
                            "name": "Cat"
                          },
                          "name": "Cotton",
                          "photoUrls": [
                            "NewPhoto.com", "secondPhoto.com"
                          ],
                          "tags": [
                            {
                              "id": 0,
                              "name": "Kitty"
                            }
                          ],
                          "status": "available"
                        }""";


        PetPojo expectedData = convertJsonToJava(strJson, PetPojo.class);
        expectedData.setId(petId);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given(spec).get("{first}/{second}");
        response.prettyPrint();

        //Do assertion
        PetPojo actualData = convertJsonToJava(response.asString(), PetPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.statusCode(), 200);
        assertEquals(actualData.getId(), expectedData.getId());
        assertEquals(actualData.getCategory().getName(), expectedData.getCategory().getName());
        assertEquals(actualData.getName(), expectedData.getName());
        assertEquals(actualData.getPhotoUrls().getFirst(), expectedData.getPhotoUrls().getFirst());
        assertEquals(actualData.getPhotoUrls().get(1), expectedData.getPhotoUrls().get(1));
        assertEquals(actualData.getTags().getFirst().getName(), expectedData.getTags().getFirst().getName());
        assertEquals(actualData.getStatus(), expectedData.getStatus());

    }

}