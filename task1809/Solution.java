package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        fileName = bufferedReader.readLine();
        FileOutputStream outputStream = new FileOutputStream(fileName);


        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);

            for (int i = 0; i < buffer.length / 2; i++) {
                byte temp = buffer[i];
                buffer[i] = buffer[buffer.length - i - 1];
                buffer[buffer.length - i - 1] = temp;
            }
            outputStream.write(buffer);
        }
        inputStream.close();
        outputStream.close();
    }
}
