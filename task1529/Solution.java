package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        reset();
    }

    public static Flyable result;

    public static void reset() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String input = bufferedReader.readLine();
            switch (input) {
                case "helicopter": {
                    result = new Helicopter();
                    break;
                }
                case "plane": {
                    int passengers = Integer.parseInt(bufferedReader.readLine());
                    result = new Plane(passengers);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
