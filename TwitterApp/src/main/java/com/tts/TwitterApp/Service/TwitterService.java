package com.tts.TwitterApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

@Service
public class TwitterService {
	@Autowired
	private Twitter twitter;
	
	@Value("${twitter_get_last_100_tweets}")
	public String twitter_get_last_100_tweets;
	
	@Value("${twitter_api_key}")
	public String twitter_api_key;
}
