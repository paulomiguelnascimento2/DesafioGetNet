package br.com.rest.tests;

import static io.restassured.RestAssured.given;
import org.junit.Test;
import br.com.rest.hook.BaseTest;

public class DeletarUsers extends BaseTest {

	@Test

	public void deletarUsers() {

		given().when().delete("/users/2").then().statusCode(204).log().all();

	}

}
