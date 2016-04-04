package hu.sol.mik.unittest.core;

import hu.sol.mik.unittest.model.MainModel;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");
	}

	public static String getHelloWorld() {
		return "Hello World";
	}

	public static String getHelloWorld2() {
		return "Hello World 2";
	}
	
	public static MainModel getMainModel() {
		return new MainModel("true", "true");
	}

}
