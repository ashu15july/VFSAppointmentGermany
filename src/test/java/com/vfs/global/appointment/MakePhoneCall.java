package com.vfs.global.appointment;


import java.net.URI;
import java.net.URISyntaxException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

public class MakePhoneCall {
	// Get your Account SID and Auth Token from https://twilio.com/console
	// To set up environment variables, see http://twil.io/secure
	//public static final String ACCOUNT_SID = System.getenv("TWILIO_ACCOUNT_SID");
	//public static final String AUTH_TOKEN = System.getenv("TWILIO_AUTH_TOKEN");

	public static void makePhoneCall() throws URISyntaxException {
		final String ACCOUNT_SID = "";
        final String AUTH_TOKEN = "";
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

		String from = "";
		String to = "";

		Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
				new URI("http://demo.twilio.com/docs/voice.xml")).create();

		System.out.println(call.getSid());
	}
}
