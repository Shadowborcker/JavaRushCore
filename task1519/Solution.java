package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals("exit")) break;
            try {
                int number = Integer.parseInt(input);
                if (number <= 0 || number >= 128) {
                    print(number);
                } else /*if (number > 0 && number < 128)*/ {
                    print(Short.parseShort(input));
                }
            } catch (NumberFormatException e) {
                try {
                    if (input.contains(".")) {
                        double fractional = Double.parseDouble(input);
                        print(fractional);
                    } else print(input);
                } catch (NumberFormatException ee) {
                    print(input);
                }
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
