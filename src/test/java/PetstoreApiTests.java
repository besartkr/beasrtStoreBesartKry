import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PetstoreApiTests {

    private final String BASE_URI = "https://petstore.swagger.io/v2";
    private final String PET_ID = "1122334455";
    private final String ORDER_ID = "998877";
    private final String USER_ID = "555";
    private final String USERNAME = "testuser1";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URI;
    }

    @Test
    public void createPetScenario() {
        String body = "{\"id\":" + PET_ID + ",\"name\":\"Cat\",\"photoUrls\":[\"https://example.com/Cat.jpg\"],\"status\":\"available\"}";

        given().contentType(ContentType.JSON).body(body)
        .when().post("/pet")
        .then().statusCode(200)
        .body("name", equalTo("Cat"))
        .body("status", equalTo("available"));
    }

    @Test
    public void updatePetScenario() {
        String body = "{\"id\":" + PET_ID + ",\"name\":\"CatUpdated\",\"photoUrls\":[\"https://google.com/Cat.jpg\"],\"status\":\"sold\"}";

        given().contentType(ContentType.JSON).body(body)
        .when().put("/pet")
        .then().statusCode(200)
        .body("name", equalTo("CatUpdated"))
        .body("status", equalTo("sold"));
    }

    @Test
    public void deletePetScenario() {
        when().delete("/pet/" + PET_ID)
        .then().statusCode(200)
        .body("message", equalTo(PET_ID));
    }

    @Test
    public void placeOrderScenario() {
        String body = "{\"id\":" + ORDER_ID + ",\"petId\":1122,\"quantity\":2,\"shipDate\":\"2025-06-27T00:00:00.000Z\",\"status\":\"placed\",\"complete\":true}";

        given().contentType(ContentType.JSON).body(body)
        .when().post("/store/order")
        .then().statusCode(200)
        .body("status", equalTo("placed"))
        .body("quantity", equalTo(2));
    }

    @Test
    public void updateOrderScenario() {
        String body = "{\"id\":" + ORDER_ID + ",\"petId\":1122,\"quantity\":3,\"shipDate\":\"2025-06-28T00:00:00.000Z\",\"status\":\"approved\",\"complete\":false}";

        given().contentType(ContentType.JSON).body(body)
        .when().post("/store/order")
        .then().statusCode(200)
        .body("status", equalTo("approved"))
        .body("quantity", equalTo(3));
    }

    @Test
    public void deleteOrderScenario() {
        when().delete("/store/order/" + ORDER_ID)
        .then().statusCode(200)
        .body("message", equalTo(ORDER_ID));
    }

    @Test
    public void createUserScenario() {
        String body = "{\"id\":" + USER_ID + ",\"username\":\"" + USERNAME + "\",\"firstName\":\"Test\",\"lastName\":\"User\",\"email\":\"test@example.com\",\"password\":\"pass123\",\"phone\":\"1234567890\",\"userStatus\":1}";

        given().contentType(ContentType.JSON).body(body)
        .when().post("/user")
        .then().statusCode(200)
        .body("message", equalTo(USER_ID));
    }



}
