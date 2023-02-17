package com.qa.rest.tests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class NewToken {
	public static String token=null;
	@Test(priority=1,groups="GetToken_Generation")
public void GetToken_Generation() {
	
		Response response=RestAssured.given().
				contentType("application/x-www-form-urlencoded; charset=utf-8")
				.formParam("grant_type", "client_credentials")
				.formParam("resource", "https://eurekaforbes-posibol365.crm8.dynamics.com")
				.formParam("client_id", "71bdbfc7-5af4-4d3d-a5f4-920e6fd491ab")
				.formParam("client_secret", "Fv37Q~vqRBl_3JxTD0VpVPeco5JMOXKIDl2pu")
				.when().post("https://login.microsoftonline.com/05a95e5d-0125-43d1-9635-af203c0fe8c4/oauth2/token");
		System.out.println(response.asString());
		String rBody=response.asString();
		JsonPath jsonpath=new JsonPath(rBody);
		
		token=jsonpath.getString("access_token");
		System.out.println(".................."+token);
		
		String successCodeValidation=response.jsonPath().get("access_token");
		System.out.println("access token is >>"+successCodeValidation);
		System.out.println("Token_Generation "+response.asString());
		Reporter.log("Token_Generation Response "+response.asString());
		int statusCode=response.getStatusCode();
		System.out.println("status Code is "+statusCode);
		Assert.assertEquals(statusCode,200);
		Reporter.log("statusCode is : "+statusCode);
		
}
	@Test(priority=2,groups="GetCustomerComponent",dependsOnGroups="GetToken_Generation")
	public void GetCustomerComponent() {
		 Response res=

				    given()
				    
				    .header("Authorization","Bearer "+token)
				    .contentType("application/json")
				    .body("\"{\\\"Caller\\\":\\\"EFLwebsite\\\",\\\"GET_CUST_COMP_DETAILS\\\":\\\"{\\\\\\\"I_MOBILENO\\\\\\\":\\\\\\\"9773430762\\\\\\\"}\\\"}\"")
				    .when()
				    .post("https://eurekaforbes-posibol365.crm8.dynamics.com/api/data/v9.1/efl_GetCustomerComponentDetails");
	System.out.println("GetCustomerComponent "+res.asString());
	Reporter.log("GetCustomerComponent Response "+res.asString());
	int statusCode=res.getStatusCode();
	System.out.println("status Code is "+statusCode);
	Assert.assertEquals(statusCode,200);
	Reporter.log("statusCode is : "+statusCode);
	}
	@Test(priority=3,groups="GetProductOptionAMC",dependsOnGroups="GetCustomerComponent")
	public void GetProductOptionAMC() {
		 Response res=

				    given()
				    
				    .header("Authorization","Bearer "+token)
				    .contentType("application/json")
				    .body("\"{\\\"Caller\\\":\\\"EFLwebsite\\\",\\\"GET_AMC_PROD_N_PRICE\\\":\\\"{\\\\\\\"I_CUSTOMER\\\\\\\":\\\\\\\"1014067245\\\\\\\",\\\\\\\"I_COMPONENTID\\\\\\\":\\\\\\\"34657053\\\\\\\",\\\\\\\"I_MPROD\\\\\\\":\\\\\\\"GWPDCTLPL00000\\\\\\\"}\\\"}\"")
				    .when()
				    .post("https://eurekaforbes-posibol365.crm8.dynamics.com/api/data/v9.1/efl_GetAMCProductPrice");
	System.out.println("GetProductOptionAMC Response "+res.asString());
	Reporter.log("GetProductOptionAMC Response "+res.asString());
	int statusCode=res.getStatusCode();
	System.out.println("status Code is "+statusCode);
	Assert.assertEquals(statusCode,200);
	Reporter.log("statusCode is : "+statusCode);
	}
	@Test(priority=4,groups="GetCustomerDetails",dependsOnGroups="GetProductOptionAMC")
	public void GetCustomerDetails() {
		 Response res=

				    given()
				    
				    .header("Authorization","Bearer "+token)
				    .contentType("application/json")
				    .body("{\"Caller\":\"EFLwebsite\",\"ContactDetails\":\"{\\\"Mobile\\\":\\\"9773430762\\\"}\"}")
				    .when()
				    .post("https://eurekaforbes-posibol365.crm8.dynamics.com/api/data/v9.1/efl_contactDetails");
	System.err.println("GetCustomerDetails Response is:"+res.asString());
	Reporter.log("GetCustomerDetails Response:"+res.asString());
	int statusCode=res.getStatusCode();
	System.out.println("status Code is "+statusCode);
	Assert.assertEquals(statusCode,200);
	Reporter.log("statusCode is : "+statusCode);
	}
	
	
	
}
