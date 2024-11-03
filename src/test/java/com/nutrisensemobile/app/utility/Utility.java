package com.nutrisensemobile.app.utility;

import java.util.Random;

public class Utility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String generateRandomString() {
		Random random = new Random();
		int minLength = 5 + random.nextInt(6); // Generates a random number between 5 and 10
		int maxLength = minLength + random.nextInt(11 - minLength); // Generates maxLength between minLength and 10
		
		String generatedString = random.ints(minLength, maxLength).toString();
		return generatedString;
	}

}
