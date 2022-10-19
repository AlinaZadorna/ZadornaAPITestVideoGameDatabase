package utils;

import games.Game;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class TestHelper extends BaseApiTest{
    private RequestSpecification specBuilder;
    private ResponseSpecification responseSpecification;

    public TestHelper(RequestSpecification specBuilder, ResponseSpecification responseSpecification) {
        this.specBuilder = specBuilder;
        this.responseSpecification = responseSpecification;
    }

    public Game getGameById(String id){
        return given().spec(specBuilder)
                .when()
                .get(URLS.VIDEOGAMES + id).as(Game.class);
    }
}
