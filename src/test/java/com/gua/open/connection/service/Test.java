package com.gua.open.connection.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String str = "ggd{agag .defjson:{pages:31,data:[\",32155,80436735]}xxx";
        Pattern pattern = Pattern.compile("(?<=defjson:)(.*)]}");
        Matcher matcher = pattern.matcher(str);
        
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
