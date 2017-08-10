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
	
	@PostMapping("subtract")
	public String subtractTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		Subtract subtract = new Subtract(first, second);
		double result = subtract.calculate();
		
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}
	
	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name="left") int first, @RequestParam(name="right") double second, Model model) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}
	
}
