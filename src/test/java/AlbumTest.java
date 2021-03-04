import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

import static io.restassured.RestAssured.given;

public class AlbumTest {
    private static final String ENDPOINT_GET_ALBUMS = "https://jsonplaceholder.typicode.com/albums";
    private static final String FIRST_TITLE = "ab rerum non rerum consequatur ut ea unde";
    private ExtractableResponse<Response> extractableResponse;

    @BeforeClass
    public void createExtractableResponse() {
        extractableResponse = given()
                .when()
                .get(ENDPOINT_GET_ALBUMS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract();
    }

    @Test
    public void checkAlbumsTittleInAlphabeticalOrderUsingDeserializeTest() {
        Album[] album = extractableResponse
                .as(Album[].class);

        Arrays.sort(album, Comparator.comparing(Album::getTitle));

        Assert.assertEquals(album[0].getTitle(), FIRST_TITLE);
    }

    @Test
    public void checkAlbumsTittleInAlphabeticalOrderUsingJsonObjectTest() {
        String[] titles = extractableResponse
                .response()
                .jsonPath()
                .getString("title")
                .split("[,]", 0);

        Arrays.sort(titles);

        Assert.assertTrue(titles[0].contains(FIRST_TITLE));
    }
}
