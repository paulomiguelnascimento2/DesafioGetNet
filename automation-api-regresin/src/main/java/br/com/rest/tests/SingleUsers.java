package br.com.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import br.com.rest.hook.BaseTest;


public class SingleUsers extends BaseTest {

	@Test

	public void validarUsuario() {

		given().when().get("/users/1")

				.then().statusCode(200).assertThat().body("data.id", equalTo(1))
				.body("data.email", equalTo("george.bluth@reqres.in")).body("data.first_name", equalTo("George"))
				.body("data.last_name", equalTo("Bluth"))
				.body("data.avatar", equalTo("https://reqres.in/img/faces/1-image.jpg"))
				.body("support.url", equalTo("https://reqres.in/#support-heading"))
				.body("support.text",
						equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
				.log().all();

	}

	@Test

	public void validarUsuarioNaoEncontrado() {

		given().when().get("/users/111")

				.then().statusCode(404).log().all();

	}

}
