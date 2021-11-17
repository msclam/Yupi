package com.ljw.singleTon;

public class Lhan {
	public static void main(String[] args) {
		
	}
}

class Some {
	private Some() {
		
	}
	
	private static Some instance = null;
	
	public static Some getInstance() {
		if (instance == null) {
			instance = new Some();
		}
		return instance;
	}
}
