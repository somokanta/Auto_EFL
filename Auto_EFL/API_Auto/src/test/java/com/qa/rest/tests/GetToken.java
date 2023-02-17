package com.qa.rest.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetToken {

	@Test
	public void AccessToken() {
		RestAssured.baseURI="https://login.microsoftonline.com";
        Response res=RestAssured.given()
        		
       .header("Cookie","fpc=AtkcXyruwYBBo-fW1uLHUzA0zhZYAQAAAOq3ftsOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd")
       .header("Postman-Token","<calculated when request is sent>")
       .header("Content-Type","application/json")
       .header("Content-Length","application/json")
       .header("Host","<calculated when request is sent>")
       .header("User-Agent","PostmanRuntime/7.31.0")
       .header("Accept","*/*")
       .header("Accept-Encoding","gzip, deflate, br")
       .header("Connection","keep-alive")
       
       
       
       .body("{\r\n"
       		+ "\"grant_type\":\"client_credentials\",\r\n"
       		+ "\"resource\":\"https://eurekaforbes-posibol365.crm8.dynamics.com\",\r\n"
       		+ "\"client_id\":\"71bdbfc7-5af4-4d3d-a5f4-920e6fd491ab\",\r\n"
       		+ "\"client_secret\":\"Fv37Q~vqRBl_3JxTD0VpVPeco5JMOXKIDl2pu\"\r\n"
       		+ "}")
       .when().post("https://login.microsoftonline.com/05a95e5d-0125-43d1-9635-af203c0fe8c4/oauth2/token").
        
      
        		
        		
       then().assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response(); 
		
		
		
}
}