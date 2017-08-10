package com.example.demo.models;

public class Whisperer {

		String st1;
	
	public Whisperer(String message) {
			
			st1 = message;
		}
	public String quiet() {
		return st1.toLowerCase();
	}
	
	
}