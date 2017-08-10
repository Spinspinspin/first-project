package com.example.demo.models;

public class Yeller {

		String st1;
	
	public Yeller(String message) {
			
			st1 = message;
		}
	public String yell() {
		return st1.toUpperCase();
	}
	
	
}
