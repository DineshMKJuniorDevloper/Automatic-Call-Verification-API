package com.example;

import java.net.URI;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@SpringBootApplication
public class CallerApiTwilioApplication implements ApplicationRunner {
	
	private final static String SID_ACCOUNT = "AC1302059b52c91312c48f59497331a005";
			private final static String AUTH_ID = "10a65677ff59c210ec91e2cae6d5c0f5";
			private final static String FROM_NUMBER="+12054967236"; //this is Automatic Caller Number
			private final static String TO_NUMBER ="+910000000000"; // this is user number

			static {
				   Twilio.init(SID_ACCOUNT, AUTH_ID);
				}
			
	public static void main(String[] args) {
		SpringApplication.run(CallerApiTwilioApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Call.creator(new PhoneNumber(TO_NUMBER), new PhoneNumber(FROM_NUMBER),
				   new URI("http://demo.twilio.com/docs/voice.xml")).create();
		
	}

}
