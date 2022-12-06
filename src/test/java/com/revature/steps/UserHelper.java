package com.revature.steps;

import java.util.Random;

public class UserHelper {

    public static String[] createRandomString(int len) {
        String[] randomString = new String[1];
        for(int i = 0; i < randomString.length; i++) {
            String possibleChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder randString = new StringBuilder();
            Random rnd = new Random();
            while (randString.length() < 8) { // length of the random string.
                int index = (int) (rnd.nextFloat() * possibleChars.length());
                randString.append(possibleChars.charAt(index));
            }
            randomString[i] = randString.toString();
        }
        return randomString;
    }
}
