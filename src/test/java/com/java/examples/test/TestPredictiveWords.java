package com.java.examples.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Based on user's input digits on a phone keypad, return a list of predictive words that matches.
 * Keypad inputs:
 * //3 -> d,e,f
 * //4 -> g,h,i
 * //5 -> j,k,l
 * Sample input: 435
 * Sample Output: "help", "hello". "helipad" etc.
 * Shorter length words should appear first.
 */
public class TestPredictiveWords {
    static final char[][] CHARS = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
            {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    //predefined dictionary with list of words populated
    static List<String> dictionary = List.of("test", "help", "hi", "tell", "hello", "dilo", "filler", "mount",
            "helipad",
            "halo", "hit", "telepathy");

    public static void main(String[] args) {
        String input = "435";
        List<String> matchedWords = getPredictiveWords(input);
        System.out.println("matched words: " + matchedWords);
    }

    private static List<String> getPrefixWords(String keyStrokes) {

        int len = keyStrokes.length();
        List<String> prefixWords = new ArrayList<>();
        if (len == 0) return prefixWords;
        buildPrefixesByKeyStrokeSearch(0, len, new StringBuilder(), prefixWords, keyStrokes);
        return prefixWords;
    }

    private static void buildPrefixesByKeyStrokeSearch(int pos, int len, StringBuilder sb, List<String> prefixWords, String keyStrokes) {
        if (pos == len) prefixWords.add(sb.toString());
        else {
            char[] letters = CHARS[Character.getNumericValue(keyStrokes.charAt(pos))];
            // handle '0' and '1' input digit as char array is empty for this input
            if (letters.length == 0) buildPrefixesByKeyStrokeSearch(pos + 1, len, sb, prefixWords, keyStrokes);
            for (char letter : letters)
                buildPrefixesByKeyStrokeSearch(pos + 1, len, new StringBuilder(sb).append(letter), prefixWords, keyStrokes);
        }
    }


    static List<String> getPredictiveWords(String input) {
        //build the prefix words token starting with the input letters
        List<String> prefixWords = getPrefixWords(input);
        System.out.println("prefixWords: " + prefixWords);
        return dictionary.stream()
                .filter((s) -> prefixWords.stream().anyMatch(s::startsWith))
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList());

        /*
        // alternate way is to stream over prefixWords and find match in dictionary and get a  matching list from
        // dictionary
        return prefixWords.stream().map((s) ->
                        dictionary.stream().filter(s1 -> s1.startsWith(s)).collect(Collectors.toList()))
                .flatMap(List::stream).sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList());
        */
    }
}
