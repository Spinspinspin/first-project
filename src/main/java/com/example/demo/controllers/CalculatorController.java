package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Divide;
import com.example.demo.models.Modulo;
import com.example.demo.models.Multiply;
import com.example.demo.models.Power;
import com.example.demo.models.Subtract;


@Controller
@RequestMapping("/maths")
public class CalculatorController {

	@GetMapping ("calculator")
	public String calculator() {
		return "/maths/calculator";
	}
	
	@PostMapping("calculator")
	public ModelAndView doit(@RequestParam(name = "left") int first, @RequestParam(name = "right") double second, @RequestParam(name="mathChoice", required=false) String mathChoice, @RequestParam(name="value", required=false) String Value,
			Model model) {
		Double result = null;
		
		
		if (mathChoice.equals("add")) {

			Adder addhold = new Adder(first, second);
			result = addhold.calculate();
			
			
			

		} else if (mathChoice.equals("subtract")) {
			Subtract subtracthold = new Subtract(first, second);
			result = subtracthold.calculate();
			

		}

		else if (mathChoice.equals("multiply")) {
			Multiply multiplyhold = new Multiply(first, second);
			result = multiplyhold.calculate();
			

		}

		else if (mathChoice.equals("divide"))		{
			Divide dividehold = new Divide(first, second);
			result = dividehold.calculate();
			

		}

		else if (mathChoice.equals("modulo")) {
			Modulo modulohold = new Modulo(first, second);
			result = modulohold.calculate();
			

		}

		else {
			Power powerhold = new Power(first, second);
			result = powerhold.calculate();
			

		}
		ModelAndView mv = new ModelAndView("/maths/calc-result");
		mv.addObject("output", result);
		return mv;
	}

}