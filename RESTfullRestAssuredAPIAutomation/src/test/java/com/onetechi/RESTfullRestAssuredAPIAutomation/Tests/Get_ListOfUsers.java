package com.onetechi.RESTfullRestAssuredAPIAutomation.Tests;

import static org.testng.Assert.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.response.*;
import org.testng.annotations.Test;
import com.onetechi.RESTfullRestAssuredAPIAutomation.Utilities.Resources;


public class Get_ListOfUsers {
	
	String parameter = "/users?";
	String page = "page=";
	int two = 2;
	
	String GETListOfUsersEndPoint = Resources.serviceEndPoint + Resources.resourceEndPoint + parameter + page + two;

	@Test
    public void shouldAnswerWithTrue() {
		
		System.out.println("GETListOfUsersEndPoint: " + GETListOfUsersEndPoint);
        Response GetListResponse = given().
				        	   when().
				        			get(GETListOfUsersEndPoint);
				        
        		GetListResponse.then()
        						.assertThat()
        					    .time(lessThan(5000L))
					            .statusCode(Resources.successfull_Status_Code).log().all()
        						.body("page", equalTo(2),
        								"per_page", equalTo(6),
        								"total", equalTo (12),
        								"total_pages", equalTo (2));
        		
        		assertNotNull(GetListResponse);
        		   
    		    String listResp = GetListResponse.getBody().asString(); 
    		    System.out.println(Resources.response_Body_Is + listResp);
    			
    			int listStatusCode = GetListResponse.getStatusCode();
    			System.err.println(Resources.response_Status_Code_Is + listStatusCode);
    			
    			long listResponseTime = GetListResponse.getTime();
    			System.out.println(Resources.response_Time_Is + listResponseTime);

    }

}
