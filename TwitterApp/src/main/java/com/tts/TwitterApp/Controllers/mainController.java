package com.tts.TwitterApp.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tts.TwitterApp.Service.NamexTweet;
import com.tts.TwitterApp.Service.TweetService;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Controller
public class mainController {
	@Autowired
	public TweetService tweetService;
	
	@GetMapping("/")
    public String main(Model model) {
		List<String> t = tweetService.getLatestTweets();
		System.out.println(t);
		return "main";
	}
	
	
	
}
