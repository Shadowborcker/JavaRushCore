package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new FirstThread());
        threads.add(new SecondThread());
        threads.add(new ThirdThread());
        threads.add(new FourhtThread());
        threads.add(new FifthThread());
    }

    public static void main(String[] args) {
    }

    public static class FirstThread extends Thread {
        @Override
        public void run() {
            while (true){

            }
        }
    }

    public static class SecondThread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class ThirdThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class FourhtThread extends Thread implements Message {
        @Override
        public void run() {
            while(!this.isInterrupted()){}
        }
        @Override
        public void showWarning() {
            this.interrupt();
        }
    }
    public static class FifthThread extends Thread {
        @Override
        public void run(){
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int sum =0;
            String string;
            while (true) {
                try {
                    string = bufferedReader.readLine();
                    if (string.equals("N")) break;
                    try {
                        sum += Integer.parseInt(string);
                    } catch (NumberFormatException e) {
                        System.out.println("Not a number");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(sum);


        }
    }
}