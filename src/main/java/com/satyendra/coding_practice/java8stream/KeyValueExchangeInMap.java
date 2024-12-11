package com.satyendra.coding_practice.java8stream;

import java.util.Map;
import java.util.stream.Collectors;

public class KeyValueExchangeInMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = Map.of(1, 11, 2, 22, 3, 33);
        System.out.println(map);
        Map<Integer, Integer> newMap = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        System.out.println(newMap);
    }
}
