import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DummyAPIget {


    @Test
    public void getDummyApi() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/";

        given().
                when().
                get("/api/v1/employees").
                then().
                assertThat().statusCode(200).
                //and().body("[0].id", equalTo("60363")).
                        and().header("Server", "Apache");
    }




}


