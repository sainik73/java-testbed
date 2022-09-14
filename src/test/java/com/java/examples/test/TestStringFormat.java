package com.java.examples.test;

import java.util.Scanner;

/**
 * Input Format *
 * Every line of input will contain a String followed by an integer.
 * Each String will have a maximum of  alphabetic characters, and each integer will be in the inclusive range from to .
 *
 * Output Format *
 * In each line of output there should be two columns:
 * The first column contains the String and is left justified using exactly  characters.
 * The second column contains the integer, expressed in exactly  digits; if the original input has less than three digits,
 * you must pad your output's leading digits with zeroes.
 *
 * Sample Input *
 * java 100
 * cpp 65
 * python 50
 * ================================Sample Output
 * java           100
 * cpp            065
 * python         050
 */
public class TestStringFormat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================ start");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            //Complete this line
            //System.out.println(formatString(s1) + formatInt(x));
            System.out.printf("%-15s%03d%n",s1,x);

        }
        System.out.println("================================done");

    }
    private static String formatString(String str){
        String template = "               ";
        if(str != null && str.length()>0 && str.length()<=15){
            str = str + template.substring(0,15-str.length());
            System.out.println("str length: " + str.length());
        }
        return str;
    }
    private static String formatInt(int i){
        String template = "";
        if(i<999){
            if(i<9){
                template = "00" + i;
            }else if(i<99){
                template = "0"+ i;
            }else template = String.valueOf(i);
        }
        return template;
    }
}
