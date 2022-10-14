import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;

public class BaseApiTest {
    public RequestSpecification specBuilder;
    public ResponseSpecification responseSpecification;

    @BeforeMethod
    public void setupRequest(){
        specBuilder = new RequestSpecBuilder().setBaseUri("http://localhost:8080/app/")
                .setAccept("application/json")
                .setContentType("application/json").build();
        responseSpecification = new ResponseSpecBuilder().expectStatusCode(HttpStatus.SC_OK)
                .expectContentType("application/json").build();
    }
}
