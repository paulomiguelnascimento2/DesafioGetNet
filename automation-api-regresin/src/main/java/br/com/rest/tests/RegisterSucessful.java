package br.com.rest.tests;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import br.com.rest.hook.BaseTest;





public class RegisterSucessful extends BaseTest {

	@Test

	public void registerSucessful() {

		Map<String, String> RegistroSucesso = new HashMap<>();

		RegistroSucesso.put("email", "eve.holt@reqres.in");
		RegistroSucesso.put("password", "pistol");

		given().contentType("application/json").body(RegistroSucesso).when().post("/register")

				.then().statusCode(200).body(containsString("id")).body(containsString("token")).log().all();

	}

	@Test

	public void registerNotSucessful() {

		Map<String, String> RegistroSucesso = new HashMap<>();

		RegistroSucesso.put("email", "eve2.holt@reqres.in");
		RegistroSucesso.put("password", "pistol");

		given().contentType("application/json").body(RegistroSucesso).when().post("/register")

				.then().statusCode(400).assertThat()
				.body("error", equalTo("Note: Only defined users succeed registration")).log().all();

	}

	@Test

	public void registerUnSucessful() {

		Map<String, String> RegistroSucesso = new HashMap<>();

		RegistroSucesso.put("email", "sydney@fife");

		given().contentType("application/json").body(RegistroSucesso).when().post("/register")

				.then().statusCode(400).assertThat().body("error", equalTo("Missing password")).log().all();

	}

}
