package com.satyendra.coding_practice.java8stream;

import java.util.List;
import java.util.stream.Collectors;

public class ListListListToList {

    public static void main(String[] args) {
        List<List<List<Integer>>> list = List.of(
                List.of(List.of(1, 2, 3), List.of(3, 4, 5)),
                List.of(List.of(5, 6, 7), List.of(7, 8, 9))
        );

        List<Integer> result = list.stream().flatMap(List::stream).flatMap(List::stream).distinct().toList();
        System.out.println(result);
    }
}
