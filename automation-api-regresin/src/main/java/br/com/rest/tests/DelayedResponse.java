package br.com.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import br.com.rest.hook.BaseTest;

public class DelayedResponse extends BaseTest {

	@Test

	public void delayedResponse() {

		given().when().get("/users?delay=3").then().statusCode(200).assertThat().body("page", equalTo(1)).assertThat()
				.body("per_page", equalTo(6)).assertThat().body("total", equalTo(12)).assertThat()
				.body("total_pages", equalTo(2)).log().all();

	}

}
