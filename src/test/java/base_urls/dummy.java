package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class dummy {

    protected RequestSpecification specification ;

    @BeforeMethod //Runs before each @Test
    public void setUpBaseURL() {
        specification = new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v2").build();
    }
}
