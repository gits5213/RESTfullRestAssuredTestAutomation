package com.onetechi.RESTfullRestAssuredAPIAutomation.Tests;

import static org.testng.Assert.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import org.testng.annotations.Test;

import com.onetechi.RESTfullRestAssuredAPIAutomation.ProtocolDesign.PostUtils;
import com.onetechi.RESTfullRestAssuredAPIAutomation.Utilities.Resources;


public class POST_CreateUser {
	
	String parameter = "/users";
	String slash = "/";

	
	String POSTUsersEndPoint = Resources.serviceEndPoint + Resources.resourceEndPoint + parameter;

	@Test
    public void shouldAnswerWithTrue() {
		
		System.out.println("GETListOfUsersEndPoint: " + POSTUsersEndPoint);
		
		System.err.println("=======POST Operation Excution Start =============");
        Response PostCreateUserResponse = given().
        					/*headers(Data.contentType, Data.ContentTypeValue,
        								Data.SubscriptionKey, Data.SubscriptionKeyValue,
        								Data.Authorization, Data.BearerToken + access_token)
        								*/
        		body(PostUtils.createUser(PostUtils.randomGivenUserName)).
				        	   when().
				        			post(POSTUsersEndPoint);
				        
        PostCreateUserResponse.then()
        						.assertThat()
        					    .time(lessThan(5000L))
					            .statusCode(Resources.successfully_Account_Created).log().all();
//        						.body("page", equalTo(2),
//        								"per_page", equalTo(6),
//        								"total", equalTo (12),
//        								"total_pages", equalTo (2));
        		
        		assertNotNull(PostCreateUserResponse);
        		   
    		    String userResp = PostCreateUserResponse.getBody().asString(); 
    		    System.out.println(Resources.response_Body_Is + userResp);
    			
    			int userStatusCode = PostCreateUserResponse.getStatusCode();
    			System.err.println(Resources.response_Status_Code_Is + userStatusCode);
    			
    			long userResponseTime = PostCreateUserResponse.getTime();
    			System.out.println(Resources.response_Time_Is + userResponseTime);
    			
    			JsonPath siteIdNumber = new JsonPath(userResp);
    	        String respoinseUserId = siteIdNumber.getString("id");
    	        System.out.println("userId: " + respoinseUserId);
    	        
    	        System.err.println("=======GET Operation Excution Start =============");
    	        
//    	        String GETUserEndPoint = POSTUsersEndPoint + slash + respoinseUserId;
//    	        System.out.println("GETIndividualUsersEndPoint: " +  GETUserEndPoint);
//    	        
//    	        Response GetUserInfo = given().
//    	        		when().
//	        			get(GETUserEndPoint);
//    	        
//    	        GetUserInfo.then()
//				.assertThat()
//			    .time(lessThan(5000L))
//	            .statusCode(Resources.successfull_Status_Code).log().all();
    	        		

    }

}
