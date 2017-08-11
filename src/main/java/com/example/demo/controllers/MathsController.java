package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Adder;
import com.example.demo.models.Subtract;

@Controller
@RequestMapping("/maths")
public class MathsController {
	
	@GetMapping("adder")
	public String adder() {
		return "maths/tryagain";
	}

	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name = "left") int first, @RequestParam(name = "right") double second,
			Model model) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();

		model.addAttribute("sum", result);
		return "maths/sum-result";
	}

	@PostMapping("subtract")
	public String subtractTwoNumbers(@RequestParam(name = "left") int first,
			@RequestParam(name = "right") double second, Model model) {
		Subtract subtract = new Subtract(first, second);
		double result = subtract.calculate();

		model.addAttribute("answer", result);
		return "maths/answer-result";
	}

}
