package request;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class team03_practise extends dummy{
    /**
     * // Base URL should be used as Spec
     * // Given https://gorest.co.in/public/v2/todos/47900
     * // When user send Request via GET Method
     * // Then Assert that Status Code is "200"
     * // And Assert that Content Type is "application/json"
     * // And Assert that Response Body is as follows:
     * {
     *     "id": 47900,
     *     "user_id": 6861183,
     *     "title": "Et minus libero aegrotatio teres quia.",
     *     "due_on": "2024-04-25T00:00:00.000+05:30",
     *     "status": "pending"
     * }
     * */

    @Test
    public void test(){
        specification.pathParams("1","todos","2","47900");

        Response response = given(specification).get("{1}/{2}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        response.then().statusCode(200).contentType("application/json");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertEquals(jsonPath.getInt("id"),47900);
        softAssert.assertEquals(jsonPath.getInt("user_id"),6861183);
        softAssert.assertEquals(jsonPath.getString("title"),"Et minus libero aegrotatio teres quia.");
        softAssert.assertEquals(jsonPath.getString("due_on"),"2024-04-25T00:00:00.000+05:30");
        softAssert.assertEquals(jsonPath.getString("status"),"pending");
        softAssert.assertAll();

    }
}
