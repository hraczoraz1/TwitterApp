package com.tts.TwitterApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainController {
	@Autowired
	private Twitter twitter;
	
	@GetMapping("/")
    public String main(Model model) {
		return "main";
	}
	
	@GetMapping("/habuma")
		public String main1(Model model) {
			TwitterProfile profile = twitter.userOperations().getUserProfile("habuma");
			model.addAttribute("habuma", profile);
			return "main";
		}
	
}
