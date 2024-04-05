package com.web.java;

import java.security.SecureRandom;

public class PasswordGenerator_34 {
	    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    private static final String NUMBERS = "0123456789";
	    private static final String SYMBOLS = "!@#$%^&*()-_=+[{]}|;:',<.>/?";

	    public static void main(String[] args) {
	        int passwordLength = 12;
	        String password = generatePassword(passwordLength);
	        System.out.println("Generated Password: " + password);
	    }

	    public static String generatePassword(int length) {
	        StringBuilder password = new StringBuilder();
	        SecureRandom random = new SecureRandom();

	       
	        password.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));
	        password.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));
	        password.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
	        password.append(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));

	        
	        for (int i = 4; i < length; i++) {
	            String randomCategory = getRandomCategory();
	            String categoryCharacters = getCategoryCharacters(randomCategory);
	            password.append(categoryCharacters.charAt(random.nextInt(categoryCharacters.length())));
	        }

	        
	        return shuffleString(password.toString());
	    }

	    private static String getRandomCategory() {
	        String[] categories = {"lowercase", "uppercase", "numbers", "symbols"};
	        SecureRandom random = new SecureRandom();
	        return categories[random.nextInt(categories.length)];
	    }

	    private static String getCategoryCharacters(String category) {
	        switch (category) {
	            case "lowercase":
	                return LOWERCASE_LETTERS;
	            case "uppercase":
	                return UPPERCASE_LETTERS;
	            case "numbers":
	                return NUMBERS;
	            case "symbols":
	                return SYMBOLS;
	            default:
	                return "";
	        }
	    }

	    private static String shuffleString(String input) {
	        char[] characters = input.toCharArray();
	        SecureRandom random = new SecureRandom();

	        for (int i = 0; i < characters.length; i++) {
	            int randomIndex = random.nextInt(characters.length);
	            char temp = characters[i];
	            characters[i] = characters[randomIndex];
	            characters[randomIndex] = temp;
	        }

	        return new String(characters);
	    }
	}


