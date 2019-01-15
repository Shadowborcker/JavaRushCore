package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        fileName = bufferedReader.readLine();
        FileOutputStream outputStreamOne = new FileOutputStream(fileName);
        fileName = bufferedReader.readLine();
        FileOutputStream outputStreamTwo = new FileOutputStream(fileName);

        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            if (buffer.length % 2 == 0) {
                for (int i = 0; i < buffer.length / 2; i++) {
                    outputStreamOne.write(buffer[i]);
                }
                for (int i = (buffer.length / 2); i < buffer.length; i++) {
                    outputStreamTwo.write(buffer[i]);
                }
            } else {
                for (int i = 0; i < buffer.length / 2 + 1; i++) {
                    outputStreamOne.write(buffer[i]);
                }
                for (int i = (buffer.length / 2) + 1; i < buffer.length; i++) {
                    outputStreamTwo.write(buffer[i]);
                }
            }

        }

        inputStream.close();
        outputStreamOne.close();
        outputStreamTwo.close();
    }
}
