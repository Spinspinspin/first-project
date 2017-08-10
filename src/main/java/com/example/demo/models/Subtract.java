package com.example.demo.models;

public class Subtract {

	int secret1;
	double secret2;
	
	public Subtract(int first, double second) {
		secret1 = first;
		secret2 = second;
	}
	
	public double calculate() {
		
		return secret1 - secret2;
	}
	
		
}
