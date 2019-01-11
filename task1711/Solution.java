package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static Person findPerson(List<Person> list, String name, String sex, Date birthDate) {
        Person person = Person.createMale(null, null);
        if (sex.equals("м")) {
            for (Person p : list) {
                if (p.getName().equals(name) & p.getSex().equals(Sex.MALE) & p.getBirthDate().equals(birthDate))
                    person = p;
            }
        } else for (Person p : list) {
            if (p.getName().equals(name) & p.getSex().equals(Sex.FEMALE) & p.getBirthDate().equals(birthDate))
                person = p;
        }
        return person;
    }


    public static void main(String[] args) {
        //start here - начни тут
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    try {
                        for (int i = 1; i < args.length; i += 3) {
                            allPeople.add(Person.createPerson(args[i], args[i + 1],
                                    new SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH).parse(args[i + 2])));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    for (int i = 1; i < args.length; i += 3) {
                        try {
                            System.out.println(allPeople.indexOf(findPerson(allPeople, args[i], args[i + 1],
                                    new SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH).parse(args[i + 2]))));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
                break;

            case "-u":
                synchronized (allPeople) {
                    try {
                        for (int i = 1; i < args.length; i += 4) {
                            allPeople.set(Integer.parseInt(args[i]), Person.createPerson(args[i + 1], args[i + 2],
                                    new SimpleDateFormat("dd/MM/yyy", Locale.ENGLISH).parse(args[i + 3])));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;

            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                    }
                }
                break;

            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        System.out.println(allPeople.get(Integer.parseInt(args[i])));
                    }
                }
                break;
        }

    }
}


