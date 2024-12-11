package com.satyendra.coding_practice.oracle;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        List<String> list = List.of("cat", "dog", "tac", "god", "act");
        // [[cat, tac, act], [dog,god]]
        Map<String, List<String>> map = new HashMap<>();

        for(String s : list) {
            String ss = sortedString(s);
            if(map.containsKey(ss)) {
                List<String> l = map.get(ss);
                l.add(s);
                map.put(ss, l);
            } else {
                List<String> l = new ArrayList<>();
                l.add(s);
                map.put(ss, l);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            for(String s : entry.getValue()) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static String sortedString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}

/*
T1 (id(pk), name, roll_no)

V

(name, rollno) -> name, (name, rollno)

1:10
I_t
T2 (id, tName, col3, t1_id(fk)) //1
* */


/*
High Traffic
Scalable
x
100x
* */