package com.tts.TwitterApp.Model;

import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

public class TwitterTemplate1 {
	String consumerKey = "..."; // The application's consumer key
	String consumerSecret = "..."; // The application's consumer secret
	String accessToken = "..."; // The access token granted after OAuth authorization
	String accessTokenSecret = "..."; // The access token secret granted after OAuth authorization
	Twitter twitter = new TwitterTemplate(consumerKey, consumerSecret, accessToken, accessTokenSecret);
}
