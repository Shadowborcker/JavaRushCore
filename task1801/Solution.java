package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> bytes = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            bytes.add(data);
        }
        bufferedReader.close();
        fileInputStream.close();
        Collections.sort(bytes, Collections.reverseOrder());
        System.out.println(bytes.get(0));
    }
}
