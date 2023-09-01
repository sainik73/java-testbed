package com.java.examples.test;

import java.util.HashMap;
import java.util.Map;

/**
 * This class tests two strings for anagrams.
 * An anagram of a string is another string that contains the same characters,
 * only the order of characters can be different. For example, “cat” and “act”
 * are an anagram of each other.
 */
public class TestAnagrams {
    public static void main(String[] args) {
        String a = "anagramm"; //"Qwgstaa";
        String b = "marganaa"; //"Qwagast";
        //System.out.println("InEfficient Algo: '" + a + "' and  '" + b + "' are Anagrams? " + isAnagram(a, b));
        //System.out.println("Efficient Algo: '" + a + "' and  '" + b + "' are Anagrams? " + isAnagramNew(a, b));
        System.out.println("Efficient Algo 2: '" + a + "' and  '" + b + "' are Anagrams? " + isAnagramNoUtilClassImpl(a,
                b));
    }

    static boolean isAnagramNew(String a, String b) {
        boolean valid = true;
        if (a.length() != b.length()) return false;

        HashMap<Character, Integer> hashMapA = new HashMap<>();
        for (char c : a.toLowerCase().toCharArray()) {
            if (hashMapA.containsKey(c)) {
                hashMapA.put(c, hashMapA.get(c) + 1);
            } else {
                hashMapA.put(c, 1);
            }
        }
        HashMap<Character, Integer> hashMapB = new HashMap<>();
        for (char c : b.toLowerCase().toCharArray()) {
            if (hashMapB.containsKey(c)) {
                hashMapB.put(c, hashMapB.get(c) + 1);
            } else {
                hashMapB.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> pair : hashMapA.entrySet()) {
            if (hashMapB.containsKey(pair.getKey())) {
                if (!pair.getValue().equals(hashMapB.get(pair.getKey()))) {
                    valid = false;
                    break;
                }
            } else {
                valid = false;
                break;
            }
        }

        return valid;
    }

    static boolean isAnagramNoUtilClassImpl(String a, String b) {
        // Complete the function
        if (a.length() != b.length()) return false;

        a = a.toLowerCase();
        b = b.toLowerCase();
        for (int i = 0; i < a.length(); i++) {
            String temp1 = String.valueOf(a.charAt(i));
            for (int j = 0; j < b.length(); j++) {
                String temp2 = String.valueOf(b.charAt(j));
                if (temp1.equals(temp2)) {
                    a = a.replaceFirst(temp1, "0");
                    b = b.replaceFirst(temp2, "0");
                    break;
                }
            }
        }
        System.out.println(a + " : " + b);
        return a.equals(b);

    }

    /**
     * isAnagram method fails for sum when the char are different but sum is same
     * e.g. "Qwgst" & "Gqwru"
     *
     * @param str1 instance of 1st string to compare
     * @param str2 instance of 2nd string to compare
     * @return boolean
     */
    static boolean isAnagram(String str1, String str2) {
        // Complete the function
        boolean valid = false;
        int sumA = 0;
        int sumB = 0;
        for (char c : str1.toLowerCase().toCharArray()) {
            sumA += c;
        }
        for (char c : str2.toLowerCase().toCharArray()) {
            sumB += c;
        }
        if (sumA == sumB) valid = true;

        return valid;

    }
}
