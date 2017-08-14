package com.example.demo.models;

public class Power {

	int secret1;
	double secret2;
	
	public Power(int first, double second) {
		secret1 = first;
		secret2 = second;
	}
	
	public double calculate() {
		
		return Math.pow(secret1,secret2);
	}
	
		
}
