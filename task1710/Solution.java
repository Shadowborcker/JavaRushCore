package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                try {
                    switch (args[2]) {
                        case "м":
                            allPeople.add(Person.createMale(args[1],
                                    new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                            break;
                        case "ж":
                            allPeople.add(Person.createFemale(args[1],
                                    new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
                            break;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println(allPeople.size() - 1);
                break;

            case "-u": {

                try {
                    switch (args[3]) {
                        case "м":
                            allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2],
                                    new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4])));
                            break;
                        case "ж":
                            allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2],
                                    new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[4])));
                            break;
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "-d": {
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                break;
            }
            case "-i": {
                System.out.println(allPeople.get(Integer.parseInt(args[1])));
                break;
            }
        }

    }
}
