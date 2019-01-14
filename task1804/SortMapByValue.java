package com.javarush.task.task18.task1804;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapByValue { //sorting map by values using stream
    public static Map<Integer, Integer> sortByValue(final Map<Integer, Integer> numberCounts) {
        return numberCounts.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
