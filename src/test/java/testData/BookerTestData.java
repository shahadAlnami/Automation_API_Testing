package testData;

import java.util.HashMap;
import java.util.Map;

public class BookerTestData {

    //This method creates a Map for the bookingdates. This is inner Map.
    public static Map<String, String> bookingdatesMethod(String checkin, String checkout) {

        Map<String, String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin", checkin);
        bookingdatesMap.put("checkout", checkout);

        return bookingdatesMap;
    }

    //This method creates the expected data for booker. Outer map.
    public static Map<String, Object> expectedDataMethod(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Map<String, String> bookingdatesMap, String additionalneeds) {

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingdatesMap);
        expectedData.put("additionalneeds", additionalneeds);

        return expectedData;
    }

}
