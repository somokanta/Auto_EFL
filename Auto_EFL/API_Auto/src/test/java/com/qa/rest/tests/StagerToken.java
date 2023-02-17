package com.qa.rest.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class StagerToken {
	public static String token=null;
	@Test(priority=1)
public void GetStagerToken() {
	
		Response response=RestAssured.given().
				contentType("application/x-www-form-urlencoded; charset=utf-8")
				.formParam("client_secret", "Fv37Q~vqRBl_3JxTD0VpVPeco5JMOXKIDl2pu")
				.formParam("client_id", "71bdbfc7-5af4-4d3d-a5f4-920e6fd491ab")
				.formParam("resource", "71bdbfc7-5af4-4d3d-a5f4-920e6fd491ab")
				.formParam("grant_type", "client_credentials")
				
				
				
				
				.when().post("https://login.microsoftonline.com/05a95e5d-0125-43d1-9635-af203c0fe8c4/oauth2/token");
		System.err.println(response.asString());
		String rBody=response.asString();
		JsonPath jsonpath=new JsonPath(rBody);
		
		token=jsonpath.getString("access_token");
		System.err.println("..................:"+token);
		
		String successCodeValidation=response.jsonPath().get("access_token");
		System.err.println("Stager access token is: >>"+successCodeValidation);
		System.err.println("GetStagerToken is: "+response.asString());
		Reporter.log("GetStagerToken Response is: "+response.asString());
		int statusCode=response.getStatusCode();
		System.out.println("status Code is "+statusCode);
		Assert.assertEquals(statusCode,200);
		Reporter.log("statusCode is : "+statusCode);
		
}
	@Test(priority=2)
	public void GetCustomerType() {
		 Response res=

				    given()
				    
				    .header("Authorization","Bearer "+token)
				    .contentType("application/json")
				    .body("{\"MobileNumber\":\"9773430762\"}")
				    .when()
				    .post("https://prod-az-func.azurewebsites.net/api/StaggeredSystemCheck/GoLivePincode");
	System.err.println("GetCustomerType: "+res.asString());
	Reporter.log("GetCustomerType Response: "+res.asString());
	int statusCode=res.getStatusCode();
	System.out.println("status Code is "+statusCode);
	Assert.assertEquals(statusCode,200);
	Reporter.log("statusCode is : "+statusCode);
	}
	
}
