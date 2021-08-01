package com.java.examples.test;

import java.util.Locale;

/**
 * Given a string s, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 * Example:
 * Input: s = "race a car" Output: false
 * Input: s = "A man, a plan, a canal: Panama" Output: true
 */
public class TestPalindrome {
    public static void main(String[] args) {
        String str = "race a car";//"0P";//"A man, a plan, a canal: Panama";//
        System.out.println("Result: " + validPalindrome2(str));
    }

    /**
     * This is a fast implementation
     * @param str
     * @return
     */
    private static boolean validPalindrome2(String str) {
        int i=0;
        int j = str.length()-1;
        char leftchar, rightchar;
        boolean leftcompare = false;
        boolean rightcompare = false;
        while(i<=j){
           leftchar = str.charAt(i);
           rightchar = str.charAt(j);
           if(Character.isLetterOrDigit(leftchar))  leftcompare = true;
           else i++;
           if(Character.isLetterOrDigit(rightchar)) rightcompare = true;
           else j--;

           if(leftcompare && rightcompare ) {
               if (Character.toLowerCase(leftchar) == Character.toLowerCase(rightchar)) { //both are same
                   i++;
                   j--;
               } else return false; //not a palindrome
           }

            //reset
            leftcompare = false;
            rightcompare = false;
            //System.out.println(leftchar + " :: "+ rightchar + " , "+i + " : "+ j);
        }
        return true;
    }

    /**
     * This is a slow implementation
     * @param str
     * @return
     */
    private static boolean validPalindrome(String str) {
       // if(str== null || str.trim().length()<1) return false;
        //prepare string
        char[] charArray = prepare(str);
        int j=charArray.length;
        for(int i=0 ;i< j; i++, j--){
            //System.out.println("charArray["+i+"] "+ charArray[i] +" : charArray["+ (j-1) + "] "+  charArray[j-1]);
            if(i<=j && charArray[i] != charArray[j-1])
                return false;

        }

        return true;
    }

    private static char[] prepare(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT);
        System.out.println("prepared String: "+ str);
        return str.toCharArray();
    }

}
