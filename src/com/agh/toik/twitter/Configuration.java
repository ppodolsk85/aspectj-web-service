package com.agh.toik.twitter;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.agh.toik.webservice.annotations.Config;

public class Configuration {
	private final String API_KEY = "3dFzfM1bFUGOLCKnODTYSHBPq";
	private final String API_SECRET = "Ny8ZUp4wI9trfhqWgecDhsW5sFRh3RmEpxBeunKnevqrkkvdub";
	
	private OAuthService service;
	private Token requestToken;
	private String authUrl;
	
	@Config(endpoint = "", method = "OAuth")
	public void config() {
		service = new ServiceBuilder()
        	.provider(TwitterApi.class)
        	.apiKey(API_KEY)
        	.apiSecret(API_SECRET)
        	.build();
		
		requestToken = service.getRequestToken();
		authUrl = service.getAuthorizationUrl(requestToken);
		
		Verifier v = new Verifier("verifier you got from the user"); /// <-verifier?
		Token accessToken = service.getAccessToken(requestToken, v);
		
		OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.twitter.com/1/account/verify_credentials.xml");
		service.signRequest(accessToken, request);
		Response response = request.send();
		System.out.println(response.getBody());
	}
}
