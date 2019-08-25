import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DummyAPITest {


    @Test
    public void getDummyApi() {

        RestAssured.baseURI="http://dummy.restapiexample.com/";

        given().
        when().
        get("/api/v1/employees").
        then().
                assertThat().statusCode(200).
                //and().body("[0].id", equalTo("60363")).
                and().header("Server", "Apache");
    }

    @Test
    public void postDummyApi(){
        RestAssured.baseURI="http://dummy.restapiexample.com/";

        body(" {\"name\":\"Ravi Chandra\",\n" +
                "\"salary\":\"95000\",\n" +
                "\"age\":\"28\"}").
                when().
                post("api/v1/create").
                then().
                assertThat().statusCode(200).
                and().header("Server", "Apache");

    }


}
