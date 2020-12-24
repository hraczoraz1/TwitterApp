package com.tts.TwitterApp.Model;

import java.util.TreeMap;

public class TwitterUser {
	private String user;
	private TreeMap<String, Integer> tweetMap;

	public TreeMap<String, Integer> getTweetMap() {
		return tweetMap;
	}

	public void setTweetMap(TreeMap<String, Integer> tweetMap) {
		this.tweetMap = tweetMap;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
