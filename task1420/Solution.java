package com.javarush.task.task14.task1420;

/* 
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.


Требования:
1. Программа должна считывать с клавиатуры 2 строки.
2. В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных с клавиатуры и успешно завершаться.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int a;
        int b;
        int nod = 0;
        while (true) {
            a = Integer.parseInt(bufferedReader.readLine());
            if (a > 0) break;
            else System.out.println("Invalid number format - enter positive number");
        }
        while (true) {
            b = Integer.parseInt(bufferedReader.readLine());
            if (b > 0) break;
            else System.out.println("Invalid number format - enter positive number");
        }

        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else b = b % a;
        }
        nod = a + b;

        System.out.println(nod);
    }
}
