package com;

import com.constant.Common;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static void main(String[] args) {
        String input = "Products are created with 132cxvx SKUs and MXX and CSV and 79 and mic7979 and m98opt options";
        findAndGenerateVariations(input);
    }

    public static void findAndGenerateVariations(String input) {
        //Lay regex chua ca so va ky tu latin tu input dau vao
        Pattern pattern = Pattern.compile(Common.REGEX);
        Matcher matcher = pattern.matcher(input);
        List<String> matchedWords = new ArrayList<>();
        while (matcher.find()) {
            matchedWords.add(matcher.group());
        }
        // In ra ket qua dau ra
        System.out.println("Matched Words: " + String.join(", ", matchedWords));

        List<String> variations = generateVariations(matchedWords);
        // In ra ket qua dau ra co chua cac bien the
        System.out.println("Variations with '-' character: " + String.join(", ", variations));
    }

    public static List<String> generateVariations(List<String> words) {
        List<String> variations = new ArrayList<>();
        Pattern pattern = Pattern.compile(Common.REGEX_NUMBER_CHARACTER);
        Pattern pattern2 = Pattern.compile(Common.REGEX_NUMBER_CHARACTER_V2);
        // Iterate over each word
        for (String word : words) {
            Matcher matcher = pattern.matcher(word);
            Matcher matcher2 = pattern2.matcher(word);
            if (matcher.find()) {
                String number = matcher.group(1);
                String character = matcher.group(2);
                if (matcher.group(1) != null && matcher.group(2) != null) {
                    variations.add(number + "-" + character);  // Basic variation
                }
            }
            if (matcher2.find()){
                String character = matcher2.group(1);
                String number = matcher2.group(2);
                String sub = matcher2.group(3);
                if (!sub.isEmpty()) {
                    variations.add(character.charAt(0) + "-" + number + sub);
                    variations.add(character.charAt(0) + "-" + number + "-" + sub);
                    variations.add(character + number + "-" + sub);
                } else {
                    variations.add(character + "-" + number);
                }
            }
        }
        return variations;
    }
}
