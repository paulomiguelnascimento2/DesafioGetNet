package br.com.rest.tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import org.junit.Test;
import br.com.rest.hook.BaseTest;
import com.github.javafaker.Faker;


public class AtualizarPatchUsers extends BaseTest {

	Faker faker = new Faker();

	String nome;
	String job;

	@Test

	public void atualizarPatchUsers() {

		Map<String, String> CreateUsuario = new HashMap<>();

		CreateUsuario.put("name", nome = faker.name().fullName());
		CreateUsuario.put("job", job = faker.job().field());

		given().contentType("application/json").body(CreateUsuario).when().patch("/users/2")

				.then().statusCode(200).body(containsString("name")).body(containsString("job"))
				.body(containsString("updatedAt")).log().all();

	}

}
