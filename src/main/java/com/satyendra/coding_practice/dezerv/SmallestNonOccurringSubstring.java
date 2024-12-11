package com.satyendra.coding_practice.dezerv;

import java.util.ArrayList;
import java.util.List;

public class SmallestNonOccurringSubstring {
    public static void main(String[] args) {
        SmallestNonOccurringSubstring obj = new SmallestNonOccurringSubstring();
        System.out.println(obj.findSmallest(new String[]{"abz", "chd"}));
    }

    private String findSmallest(String[] arr) {
        List<String> resList = new ArrayList<>();
        for(char ch = 'a' ; ch <= 'z' ; ch++) {
            resList.add(String.valueOf(ch));
        }

        while(true) {
            for(String str : resList) {
                boolean isSubstring = false;
                for(String s: arr) {
                    if(s.contains(str)) {
                        isSubstring = true;
                        break;
                    }
                }
                if(!isSubstring) {
                    return str;
                }
            }
            resList = generateNext(resList);
        }
    }

    private List<String> generateNext(List<String> resList) {
        List<String> res = new ArrayList<>();
        for(String str : resList) {
            for(char ch = 'a' ; ch <= 'z' ; ch++) {
                res.add(str + ch);
            }
        }
        return res;
    }
}
