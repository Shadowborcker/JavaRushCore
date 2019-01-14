package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {

    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {


        try {
            BufferedReader fileNameReader = new BufferedReader(new InputStreamReader(System.in));
            String fileNameOne = fileNameReader.readLine();
            String filenameTwo = fileNameReader.readLine();
            String line, line2;
            BufferedReader fileReader = new BufferedReader(new FileReader(fileNameOne));

            while ((line = fileReader.readLine()) != null) {
                allLines.add(line);
            }
            fileReader = new BufferedReader(new FileReader(filenameTwo));

            while ((line2 = fileReader.readLine()) != null) {
                forRemoveLines.add(line2);
            }
            fileNameReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }

}
