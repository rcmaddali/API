import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class GooglePlaceAPITest {


    @Test
    public void googlePlaceLocationTest() {

        RestAssured.baseURI="https://maps.googleapis.com";

        given().

        param("location","-33.8670522,151.1957362").
        param("radius","50").
        param("Key","AIzaSyCBtDVczOvwjJygFGfqI-O3ahXi-CTJcZU").
        when().
        get("/maps/api/place/nearbysearch/json").
        then().
                assertThat.statusCode(200).
                and.contentType(ContentType.JSON).
                and.body("results[0].name", equalTo("Sydney")).
                and.header("Server", "pablo");
    }


}
