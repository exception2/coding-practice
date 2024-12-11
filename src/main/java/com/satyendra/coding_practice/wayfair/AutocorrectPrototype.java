package com.satyendra.coding_practice.wayfair;

import java.util.*;

public class AutocorrectPrototype {
    public static void main(String[] args) {
        AutocorrectPrototype autocorrectPrototype = new AutocorrectPrototype();
        System.out.println(autocorrectPrototype.getSearchResult(Arrays.asList("duel", "speed", "dule", "cars"), Arrays.asList("spede", "deul")));
    }

    private List<String> getSearchResult(List<String> words, List<String> queries) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0 ; i < words.size() ; i++) {
            String key = words.get(i);
            StringBuilder sb = new StringBuilder(key);
        }
        return null;
    }

}
