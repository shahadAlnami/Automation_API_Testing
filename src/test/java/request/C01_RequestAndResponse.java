package request;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class C01_RequestAndResponse {

    /****/

/*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
    And
        Print Connection and Date headers on console
    And
        Print all headers on console

*/

    public static void main(String[] args) {

        /** 1. User sends a GET Request to the url **/
        // to send a request and save the response
        Response response = RestAssured.get("https://restful-booker.herokuapp.com/booking");
        //print the response
//        response.prettyPrint();

        /** 2. HTTP Status Code should be 200 **/
        // return the status code from the response
        int statusCode = response.statusCode();
        System.out.println("\nstatusCode = " + statusCode);//200

        /** 3. Content Type should be JSON **/
        String contentType = response.contentType();
        System.out.println("\ncontentType = " + contentType);

        /** 4.Status Line should be HTTP/1.1 200 OK **/
        String statusLine = response.statusLine();
        System.out.println("\nstatusLine = " + statusLine);

        /** 5. Print Connection and Date headers on console **/
        String connection = response.header("Connection");
        System.out.println("\nconnection = " + connection);
        String date = response.header("Date");
        System.out.println("date = " + date);

        /** 6. Print all headers on console **/
        Headers headers = response.headers();
        System.out.println("\nheaders = " + headers);
    }

}
