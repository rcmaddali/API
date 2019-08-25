import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DummyAPITest {


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

    @Test
    public void postDummyApi() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/";
        String postBody = "{" +
                "\"name\":\"Krish\"," +
                "\"salary\":\"95000\"," +
                "\"age\":\"28\"" +
                "}";

        body(postBody).
                when().
                post("api/v1/create").
                then().
                assertThat().statusCode(200).
                and().header("Server", "Apache");

    }


}


