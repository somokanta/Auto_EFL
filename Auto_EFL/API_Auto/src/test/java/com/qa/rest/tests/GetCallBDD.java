package com.qa.rest.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetCallBDD {

	@Test
	public void GetAccessToken() {
		
		String Url="https://login.microsoftonline.com/05a95e5d-0125-43d1-9635-af203c0fe8c4/oauth2/token";
		
		RequestSpecification http_req=RestAssured.given()
								
				/*.header("grant_type", "client_credentials")
				.header("resource", "https://eurekaforbes-posibol365.crm8.dynamics.com")
				.header("client_id", "71bdbfc7-5af4-4d3d-a5f4-920e6fd491ab")
				.header("client_secret", "Fv37Q~vqRBl_3JxTD0VpVPeco5JMOXKIDl2pu")
				.body("");
				//.header("Connection","keep-alive");
*/		
				
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
			       		+ "}");
		            
		Response response=http_req.post(Url);
		int statusCode=response.getStatusCode();
		 String response_body=response.asString();
		 System.out.println("-----statusCode------"+statusCode);
		 System.out.println("-----response_body------"+response_body);
		
		
		
		 
		 
	}}
		 
		 
			/*
			 * given().
			 * 
			 * when().post(
			 * "https://elcorobqam2.iksulalive.com/index.php/rest/V1/app/orob/login").
			 * 
			 * //get("https://elcorobqam2.iksulalive.com/index.php/rest/V1/app/orob/login").
			 * 
			 * then(). assertThat().
			 * 
			 * statusCode(200);
			 * 
			 * //and().
			 * 
			 * //body("MRData.CircuitTable.Circuits.circuitID",hasSize(20)). //and().
			 * //header("content-length",equalTo("4552"));
			 * 
			 * }
			 * 
			 * @Test public void register() {
			 * 
			 * //given(). //when(). //then(). //assert() given().
			 * 
			 * when().
			 * get("https://elcorobqam2.iksulalive.com/index.php/rest/V1/app/orob/register/"
			 * ).
			 * 
			 * then(). assertThat().
			 * 
			 * statusCode(200);}
			 * 
			 * @Test public void test2() {
			 * 
			 * //given(). //when(). //then(). //assert() given().
			 * 
			 * when(). get("http://ergast.com/api/f1/2017/circuits.json").
			 * 
			 * then(). assertThat().
			 * 
			 * statusCode(200);}
			 * 
			 * @Test public void test3() {
			 * 
			 * //given(). //when(). //then(). //assert() given().
			 * 
			 * when(). get("http://ergast.com/api/f1/2017/circuits.json").
			 * 
			 * then(). assertThat().
			 * 
			 * statusCode(200);}
			 * 
			 * @Test public void test4() {
			 * 
			 * //given(). //when(). //then(). //assert() 
			 * 
			 * given().
			 * 
			 * when(). get("http://ergast.com/api/f1/2017/circuits.json").
			 * 
			 * then(). assertThat().
			 */
		
		//statusCode(200);}
//}
