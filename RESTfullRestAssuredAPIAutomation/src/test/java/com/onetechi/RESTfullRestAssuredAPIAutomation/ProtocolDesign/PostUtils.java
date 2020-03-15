package com.onetechi.RESTfullRestAssuredAPIAutomation.ProtocolDesign;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class PostUtils {
	
	public static String zoneId = "zoneId";
    public static String serialNo ="serialNo";
    
    
    
     //29 MINUTE Past Time Stamp
    public static Instant  twentyNineMunitePastTime = Instant.now().minus(29, ChronoUnit.MINUTES);
    public static Instant  thirtySecondPastTime = Instant.now().minus(30, ChronoUnit.SECONDS);
    public static Instant  oneMinutePastTime = Instant.now().minus(1, ChronoUnit.MINUTES);
    
    
    //Current UTC Time Stamp
    public static Instant  currentTime = Instant.now();
    
    public static String bodySerialNumber = "ABCXYZ" + PostUtils.fiveDigitrRndomNumber();
    public static int randomNumber =  new Random().nextInt(100);
    
    public static String raGivennames[] = {"abcde", "fghij", "klmno", "pqrst", "uvwxyx"};
    public static String ranfamilyName[] = {"abcdek", "fghijh", "klmnog", "pqrstf", "uvwxyx", "acdefx", "ijmnop"};
    
    
    public static String randomGivenUserName =  raGivennames[ new Random().nextInt(raGivennames.length)];
    public static String randomFamilyName =  ranfamilyName[ new Random().nextInt(ranfamilyName.length)];
	
	
    public static int fiveDigitrRndomNumber() {
        int fiveDigitRandomNumber = 10000 + new Random().nextInt(90000);
        return fiveDigitRandomNumber;
    }
	
	public static String createUser(String userName) {
		
		String creatRandomUsers = 
				"{\n" + 
				"    \"name\": "+userName+",\n" + 
				"    \"job\": \"leader\"\n" + 
				"}";
		
		return creatRandomUsers;
		
	}

}
