package com.example.demo.models;

public class Multiply {

	int secret1;
	double secret2;
	
	public Multiply(int first, double second) {
		secret1 = first;
		secret2 = second;
	}
	
	public double calculate() {
		
		return secret1 * secret2;
	}
	
		
}
