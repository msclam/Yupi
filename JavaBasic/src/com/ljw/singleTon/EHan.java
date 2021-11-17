package com.ljw.singleTon;

public class EHan {
	public static void main(String[] args) {
		
	}
}

class Other {
	private Other() {
		
	}
	
	private static Other instance = new Other();
	
	public static Other getInstance() {
		return instance;
	}
}


