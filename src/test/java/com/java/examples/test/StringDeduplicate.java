package com.java.examples.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Purpose of this class is to do string deduplication
 */
public class StringDeduplicate {
    public static void main(String[] args) {
        String input = "aabbccdeeaffrtr"; //target should be to get "abcde"

        //StringIterateAndReplace(input);
        StringIterateAndReplaceV2(input);
        System.out.println("----END----");

    }

    static void StringIterateAndReplaceV2(String input){
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArray = input.toCharArray();
        Set set = new HashSet();
        for (char c: charArray) {
            if(set.add(""+c)) stringBuilder.append(c);;
        }
        System.out.println("Result is " + stringBuilder.toString());

        //join using streams
        System.out.println("Joined by Stream: " + set.stream().collect(Collectors.joining()));
    }

    static void StringIterateAndReplace (String input){
        char[] charArray = input.toCharArray();
        Set<Character> sb = new HashSet();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i < charArray.length; i++){
            for(int j=1; j < charArray.length -1; j++)
                if(charArray[i] == charArray[j] && !sb.contains(charArray[i])){
                    sb.add(charArray[i]);
                    break;
                }
        }
        for (Character c:sb) {
            stringBuilder.append(c);
        }

        System.out.println("Result is " + stringBuilder.toString());
    }
}
