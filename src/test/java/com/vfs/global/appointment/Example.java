package com.vfs.global.appointment;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    

    public static String getTwilioUnavilable() {
    	final String ACCOUNT_SID = "";
        final String AUTH_TOKEN = "";
    	
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(""),
                new com.twilio.type.PhoneNumber(""),
                "koi slots dila do")
            .create();
        
        return message.getSid();
    }
    
    public static String getTwilioAvailable() {
    	final String ACCOUNT_SID = "";
        final String AUTH_TOKEN = "";
    	
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(""),
                new com.twilio.type.PhoneNumber(""),
                "Slots available")
            .create();
        
        return message.getSid();
    }
}


