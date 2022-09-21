package br.com.rest.hook;

import io.restassured.http.ContentType;

public interface Constantes {
	
	String APP_BASE_URL = "https://reqres.in/api";
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	
	Long Max_Timeout = 50000000L;
	

}
