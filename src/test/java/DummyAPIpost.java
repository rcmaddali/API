import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

import java.util.HashMap;


public class DummyAPIpost {


    @Test
    public void postDummyApi() {
        RestAssured.baseURI = "http://dummy.restapiexample.com/";
        HashMap<String, String> details = new HashMap<String, String>();
        details.put("name", "DummyName13");
        details.put("salary", "95000");
        details.put("age", "28");

            Response res =   given().
                when().
                    body(details).
                    post("api/v1/create").
                then().
                    assertThat().statusCode(200).
                    and().header("Server", "Apache").
                extract().
                    response();
        String responseAsString = res.asString();
        JsonPath jp = new JsonPath(responseAsString);
        String age = jp.get("age");
        String name = jp.get("name");
        String salalry = jp.get("salary");
        System.out.println("Age is : "+ age);
        System.out.println("Name is : "+name);
        System.out.println("Salary is : "+salalry);
    }
}

