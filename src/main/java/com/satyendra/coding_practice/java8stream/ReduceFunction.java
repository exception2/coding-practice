package com.satyendra.coding_practice.java8stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceFunction {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 3, 4, 2, 5);

        long count = list.stream().count();
        System.out.println(count);

        long sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        long max = list.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        System.out.println(max);

        Map<Integer, Long> countMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countMap);
        Map<Integer, List<Integer>> allIndexMap = list.stream().collect(Collectors.groupingBy(Function.identity()));
        System.out.println(allIndexMap);
        Map<Integer, List<Integer>> allIndexMap1 = IntStream.range(0, list.size()-1)
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity()));
        System.out.println(allIndexMap1);
    }
}
