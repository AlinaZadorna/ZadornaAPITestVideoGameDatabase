import Users.UsersListItem;
import games.Game;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.URLS;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITests extends BaseApiTest {

    @Test
    public void getAllGames() {
        long responseTime = given().spec(specBuilder)
                .when()
                .get(URLS.VIDEOGAMES)
                .then()
                .spec(responseSpecification)
                .log()
                .body()
                .extract()
                .response()
                .getTime();
        Assert.assertTrue(responseTime < 3000);
    }

    @Test
    public void addGameWithPOJO() {

        Game gamesPostRequestPayload = new Game
                (8, "2022-10-22", "AlGame2", "Universal", 26, "Shooter");
        given().spec(specBuilder)
                .body(gamesPostRequestPayload)
                .when()
                .post(URLS.VIDEOGAMES)
                .then()
                .spec(responseSpecification)
                .log()
                .body();
    }

    @Test
    public void getOneGameByID() {
        Response response = given().spec(specBuilder)
                .when()
                .get(URLS.VIDEOGAMES + "8");
        Game game = response.as(Game.class);
        Assert.assertEquals(game.getName(), "SimCity 2000");
    }

    @Test
    public void updateNameAndCategory() {
        Response response = given().spec(specBuilder)
                .when()
                .get(URLS.VIDEOGAMES + "9");
        Game game = response.as(Game.class);
        game.setCategory("Shooter");
        game.setName("Counter-Strike");
        given().spec(specBuilder)
                .body(game)
                .when()
                .put("/videogames/" + game.getId())
                .then()
                .spec(responseSpecification)
                .assertThat()
                .body("name", equalTo("Counter-Strike"))
                .body("category", equalTo("Shooter"));
    }

    @Test
    public void jsonDeserialization() {
        Response response = given()
                .when()
                .get(URLS.USERS);
        List<UsersListItem> users = Arrays.asList(response.as(UsersListItem[].class));
        System.out.println(users);
    }
}
