package com.satyendra.coding_practice.java8stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveImmediateDuplicate {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,1,2,3,3,4,4,4);
        List<Integer> result = removeDuplicate(list);
        System.out.println(result);
    }

    private static List<Integer> removeDuplicate(List<Integer> list) {
        return IntStream.range(0, list.size() - 1)
                .filter(index -> index == 0 || !Objects.equals(list.get(index - 1), list.get(index)))
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }
}
