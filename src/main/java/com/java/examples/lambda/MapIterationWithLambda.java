package com.java.examples.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MapIterationWithLambda {
    private static Map<String, Integer> personMap = new HashMap<String, Integer>();
    private static Logger logger = Logger.getLogger(MapIterationWithLambda.class.getName());

    public static void main(String[] args) {
        personMap.put("Alvin", 21);
        personMap.put("Kevin", 36);
        personMap.put("Kiara", 35);
        personMap.put("Alex", 15);
        personMap.put("Maya", 45);
        String inputValue ="Kevin";// "Alvin";

        // prior to java 8
        for (Map.Entry<String, Integer> entry : personMap.entrySet()) {
            logger.info("Prior key: " + entry.getKey() + ", value: " + entry.getValue());
        }

        // java 8
        personMap.forEach((k,v)->logger.info("key: " + k + ", value: " + v));


        //filter map
        //Map -> Stream -> Filter -> String
        Integer result =  personMap.entrySet().stream()
                .filter(e -> e.getKey().equals(inputValue))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
        logger.info(() -> "Key Exists. Value: " + result);

        //Map -> Stream -> Filter -> String
        String newinputValue = "Mia";
        Integer nonExistResult =  personMap.entrySet().stream()
                .filter(e -> e.getKey().equals(newinputValue))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(null);
        logger.info(() -> "Key Does not Exists. Value: " + nonExistResult);

    }

}
