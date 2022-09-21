package br.com.rest.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import br.com.rest.hook.BaseTest;


public class LoginSucessful extends BaseTest {

	@Test

	public void registerSucessful() {

		Map<String, String> RegistroSucesso = new HashMap<>();

		RegistroSucesso.put("email", "eve.holt@reqres.in");
		RegistroSucesso.put("password", "cityslicka");

		given().contentType("application/json").body(RegistroSucesso).when().post("/login")

				.then().statusCode(200).body(containsString("token")).log().all();

	}

	@Test

	public void loginUnSucessful() {

		Map<String, String> RegistroSucesso = new HashMap<>();

		RegistroSucesso.put("email", "peter@klaven");

		given().contentType("application/json").body(RegistroSucesso).when().post("/login")

				.then().statusCode(400).assertThat().body("error", equalTo("Missing password")).log().all();

	}

}
