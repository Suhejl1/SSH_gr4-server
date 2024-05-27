package com.sshproject.bookstore.Helpers;

import java.util.ArrayList;
import java.util.List;

public class StringManipulators {
    public static String getSubstringWithoutSlashes(String pattern, String input) {
        int count = countSlashes(pattern);
        StringBuilder result = new StringBuilder(input);
        for (int i = input.length() - 1; i >= 0 && count > 0; i--) {
            if (input.charAt(i) == '/') {
                count--;
                result.delete(i, input.length());
            }
        }
        return result.toString();
    }

    private static int countSlashes(String pattern) {
        int count = 0;
        for (char c : pattern.toCharArray()) {
            if (c == '/') {
                count++;
            }
        }
        return count;
    }

    public static String[] splitPath(String path) {
        // Remove leading and trailing slashes
        path = path.replaceAll("^/|/$", "");

        // Split the path by slashes
        String[] parts = path.split("/");

        return parts;
    }

    public static List<String> extractSubstring(String input, String target) {
        String [] inputParts = StringManipulators.splitPath(input);
        String[] targetParts = StringManipulators.splitPath(target);
        int count = targetParts.length;

        List<String> returnString = new ArrayList<>();

        for(int i= inputParts.length-count;i<inputParts.length;i++){
            returnString.add(inputParts[i]);
        }

        return returnString; // Target not found
    }


    public static void main(String[] args) {
        String pattern = "/id";
        String input = "/api/v1/faq/1";
        String result = getSubstringWithoutSlashes(pattern, input);
        System.out.println("Result: " + result); // Output: "/api/v1/faq"
    }
}
