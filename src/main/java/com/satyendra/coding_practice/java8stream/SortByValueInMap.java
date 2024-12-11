package com.satyendra.coding_practice.java8stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByValueInMap {
    public static void main(String[] args) {

        Map<Integer, Integer> map = Map.of(4, 40, 2, 20, 3,10, 1, 10);
        Map<Integer, Integer> sortedByValueMap = map.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(sortedByValueMap);
    }
}
