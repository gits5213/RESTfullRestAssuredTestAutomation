package ittciwebsite.com.test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import Objects.Users;
import io.restassured.response.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class AppTest {

    String parameter = "/users?";
    String page = "page=";
    int two = 2;
    String GETListOfUsersEndPoint = "https://reqres.in/api" + parameter + page + two;
    String baseDir = System.getProperty("user.dir");
    String filePath = baseDir + "/src/test/java/utilities/sample.json";

    @Test
    public void appTest() {
        System.out.println("endpoint: " + GETListOfUsersEndPoint);
        System.out.println(filePath);
        Response GetListResponse = given().
                when().
                get(GETListOfUsersEndPoint);
        GetListResponse.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(200).log().all();


        ObjectMapper mapper = new ObjectMapper();
        try {
            Users user = mapper.readValue(new File(filePath), Users.class);
            int pageIdNumber = user.getPage();
            System.out.println("=============Page Id Number: ===========" + pageIdNumber);
            Assert.assertEquals(2, pageIdNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
