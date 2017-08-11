package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Subtract;
import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	//this is where the local host goes when called up in browser to localhost
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@GetMapping("message")//URL to which the form submits
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String message) {
		ModelAndView mv = new ModelAndView("helloworld/message");//this is from the path src/main/resources/templates/helloworld/message.html
		Yeller yeller = new Yeller(message);
		String result = yeller.yell();
		
		mv.addObject("title", title);
		mv.addObject("message", result);
		return mv;
	}
	 
	@GetMapping("whisper")
	public ModelAndView whisper(@RequestParam(required=false, defaultValue="«shhhhhh»") String whisper) {
		ModelAndView mv = new ModelAndView("helloworld/whisper");
		Whisperer quiet = new Whisperer(whisper);
		String result = quiet.quiet();
		
		mv.addObject("title", title);
		mv.addObject("message", result);
		return mv;
	}
	
	@GetMapping("say-something")
	public String makeAChoice(
			@RequestParam(required=false, defaultValue="«silence»")
			String choice,
			String speechChoice,
			Model updown
		) {
		//if speechChoice is yell
		if (speechChoice.equals("yell")) {
			//make choice loud
			Yeller yellhold = new Yeller(choice);
			String loud = yellhold.yell();
			updown.addAttribute("output", loud);
		} else {//otherwise
			//make choice quiet
			Whisperer quiethold = new Whisperer(choice);
			String quiet = quiethold.quiet();
			updown.addAttribute("output", quiet);
		}
		
		return "helloworld/mixed-messages";
	}
		
	
	
}
