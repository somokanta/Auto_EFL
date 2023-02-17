package com.qa.rest.tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class NewPost {
	
	
		@Test
		public void register() {
			//RequestSpecifications rs=  
			  //rs.heagiven().header
			  given()
			  .when()
			  
			  .get("https://elcorobqam2.iksulalive.com/index.php/rest/V1/app/orob/register/")
			  
			  .then(). assertThat().
			 
			 statusCode(200);
			  
		
		}	
}
