package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> countFrequencies = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        FileInputStream fileInputStream = new FileInputStream(filename);

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            countFrequencies.add(data);
        }
        bufferedReader.close();
        fileInputStream.close();

        Map<Integer, Integer> hashMap = new HashMap<>();  //hashMap to store number of occurrences

        for (Integer i : countFrequencies) {  //counting number of occurrences
            Integer j = hashMap.get(i);
            hashMap.put(i, (j == null) ? 1 : j + 1);
        }

        SortMapByValue sortMapByValue = new SortMapByValue(); // sorting map using stream
        hashMap = sortMapByValue.sortByValue(hashMap);

        for (Integer entry : hashMap.keySet()) { // printing most frequent bytes
            if (hashMap.values().toArray()[0].equals(hashMap.get(entry))) {
                String key = entry.toString();
                System.out.print(key + " ");
            }


        }

    }
}


