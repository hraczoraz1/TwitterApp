package com.tts.TwitterApp.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.URLEntity;
 
@Service
public class TweetService {
 
    @Autowired
    private Twitter twitter;
 
    
    public List<String> getLatestTweets(String string){
        List<String> tweets = new ArrayList<>();
        try {
        	Paging page = new Paging (1, 100);//page number, number per page
        	
            ResponseList<Status> userTimeLine = twitter.getUserTimeline(string, page);
            
            for (Status status : userTimeLine) {
                tweets.add(status.getText());
            }
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }
        
        return tweets;
    }
    
    public LinkedHashMap<String, Integer> getTopTenWords (String string) {
    	 List<String> tweets = new ArrayList<>();
         try {
         	Paging page = new Paging (1, 100);//page number, number per page
         	
             ResponseList<Status> userTimeLine = twitter.getUserTimeline(string, page);
             
             
             for (Status status : userTimeLine) {
                 tweets.add(status.getText());
             }
         } catch (TwitterException e) {
             throw new RuntimeException(e);
         }
         
         ArrayList<String> wordArray = new ArrayList<String>();
       
         for (String word: tweets) {
        	 for (String w: word.split(" ")){
        		 wordArray.add(w.toLowerCase());
        	 }
        	 
         }
         
         Map<String, Integer> frequencyMap = new HashMap<>();
         for (String s: wordArray){
             Integer count = frequencyMap.get(s);
             if (count == null)
                 count = 0;
  
             frequencyMap.put(s, count + 1);
         }
         

         LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
          
         frequencyMap.entrySet()
             .stream()
             .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
             .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));    
         
         return sortedMap;
         
    }

    public List<String> getLinksTweeted (String string){
    	List<URLEntity> linksFound = new ArrayList<>();
    	List<String> rawLinks = new ArrayList<>();
        try {
        	Paging page = new Paging (1, 100);//page number, number per page
        	
            ResponseList<Status> userTimeLine = twitter.getUserTimeline(string, page);
            
            
            for (Status tweet : userTimeLine) {
                for(URLEntity urle: tweet.getURLEntities()) {
                	linksFound.add(urle);
                }
            }
        } catch (TwitterException e) {
            throw new RuntimeException(e);
        }
        
        for(URLEntity expandUrl: linksFound) {
        	rawLinks.add(expandUrl.getExpandedURL());
        }

        
    	return rawLinks;
    }

    
}
