package com.tts.TwitterApp.Controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.List;
import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tts.TwitterApp.Model.TwitterUser;
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
    public String main(@ModelAttribute TwitterUser request, Model model) {
		List<String> userTweets = tweetService.getLatestTweets("@KidFriendlyDC");
		model.addAttribute("request", request);
		model.addAttribute("userTweets", userTweets);
		return "main";
	}
	
	@GetMapping("/userTweets")
    public String userTweetsmapping
    (Model model) {
		List<String> userTweets = tweetService.getLatestTweets("@KidFriendlyDC");
		model.addAttribute("userTweets", userTweets);
		return "userTweets";
	}
	
	@PostMapping("/inputUser_Get_100_tweets")
	public String inputUserReturn100Tweets(@ModelAttribute TwitterUser request, Model model){
		List<String> userTweets = tweetService.getLatestTweets(request.getUser());
		model.addAttribute("userTweets", userTweets);
		return "userTweets";
	}
	
}
