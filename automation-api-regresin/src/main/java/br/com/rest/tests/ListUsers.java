package br.com.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import br.com.rest.hook.BaseTest;


public class ListUsers extends BaseTest {

	@Test

	public void validarListaUsuario() {

		given().when().get("/users")

				.then().statusCode(200).body(containsString("george.bluth@reqres.in")).assertThat()
				.body("page", equalTo(1)).assertThat().body("per_page", equalTo(6)).assertThat()
				.body("total", equalTo(12)).assertThat().body("total_pages", equalTo(2)).log().all();

	}

	@Test

	public void validarListaUsuarioPaginacao() {

		given().when().get("/users ?page=2")

				.then().statusCode(200).assertThat().body("page", equalTo(2)).assertThat().body("per_page", equalTo(6))
				.assertThat().body("total", equalTo(12)).assertThat().body("total_pages", equalTo(2))

				.log().all();

	}

}
