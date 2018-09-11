package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern patternForList = Pattern.compile("(?<=[&?]).*?(?=[&=]|$)");
        Pattern patternForAlert = Pattern.compile("(?<=[&?]).*?(?=[&]|$)");
        Matcher matcher = patternForList.matcher(s);
        List<String> list = new ArrayList<>();

        while (matcher.find())
        {
            list.add(matcher.group());
        }
        for (String match : list) {
            System.out.print(match+" ");
        }
        System.out.println();
        matcher = patternForAlert.matcher(s);
        list.clear();
        while (matcher.find())
        {
            list.add(matcher.group());
        }

        for (String pair: list) {
            if (pair.contains("obj")){
                String[] keyValue = pair.split("=");
                try {
                    alert(Double.parseDouble(keyValue[1]));
                } catch (Exception e) {
                    alert(keyValue[1]);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
