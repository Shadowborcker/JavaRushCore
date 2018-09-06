package com.javarush.task.task14.task1419;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        for (int i = 0; i < 9; i++) {
            try {
                switch (i) {
                    case 0: throw new IOException();
                    case 1: throw new IllegalAccessException();
                    case 2: throw new IllegalArgumentException();
                    case 3: throw new NumberFormatException();
                    case 4: throw new IllegalMonitorStateException();
                    case 5: throw new IllegalStateException();
                    case 6: throw new IllegalThreadStateException();
                    case 7: throw new IndexOutOfBoundsException();
                    case 8: throw new InstantiationException();
                    case 9: throw new InterruptedException();
                }

            } catch (Exception e) {
                exceptions.add(e);

            }
        }


    }
}
