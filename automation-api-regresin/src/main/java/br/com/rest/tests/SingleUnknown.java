package br.com.rest.tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import br.com.rest.hook.BaseTest;


public class SingleUnknown extends BaseTest {

	@Test

	public void validarSingleUnknown() {

		given().when().get("/unknown")

				.then().statusCode(200).assertThat().body("page", equalTo(1)).assertThat().body("per_page", equalTo(6))
				.assertThat().body("total", equalTo(12)).assertThat().body("total_pages", equalTo(2)).log().all();

	}

	@Test

	public void validarSingleUnknownPorId() {

		given().when().get("/unknown/1")

				.then().statusCode(200).assertThat().body("data.id", equalTo(1)).body("data.name", equalTo("cerulean"))
				.body("data.year", equalTo(2000)).body("data.color", equalTo("#98B2D1"))
				.body("data.pantone_value", equalTo("15-4020"))
				.body("support.url", equalTo("https://reqres.in/#support-heading"))
				.body("support.text",
						equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
				.log().all();

	}

	@Test

	public void validarSingleUnknownNaoEncontrado() {

		given().when().get("/unknown/23").then().statusCode(404).log().all();

	}

}
