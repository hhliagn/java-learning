package com.javalearning.demo.test.strings;

import java.util.Scanner;
import java.util.regex.MatchResult;

public class ThreatAnalyzer {
    static String ThreatData = "";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(ThreatData);
        String pattern = "";
        while (scanner.hasNext(pattern)) {
            MatchResult match = scanner.match();
            String group = match.group(1);
            String group1 = match.group(2);
            System.out.println(group + group1);
        }
    }
}
