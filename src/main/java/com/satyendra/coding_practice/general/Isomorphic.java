package general;

import java.util.*;

public class Isomorphic {
    public static void main(String[] args) {
        Isomorphic i = new Isomorphic();
        System.out.println(i.isIsomorphic("egg", "add"));
    }
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m) {
            return false;
        }
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        for(int i = 0 ;i < n ; i++) {
            int diff = s.charAt(i) - t.charAt(i);
            if(smap.containsKey(s.charAt(i)) || tmap.containsKey(t.charAt(i))) {
                if(smap.containsKey(s.charAt(i)) && tmap.containsKey(t.charAt(i))) {
                    if(smap.get(s.charAt(i)) != t.charAt(i) || tmap.get(t.charAt(i)) != s.charAt(i)) {
                        return false;
                    } else {
                        continue;
                    }
                }
                return false;
            } else {
                smap.put(s.charAt(i), t.charAt(i));
                tmap.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for(int i : nums) {
            set.add(i);
        }
        List<Integer> list = set.stream().toList();
        int last = list.get(0);
        int lastIndex = 0;
        int max = 1, len = 1;
        for(int i = 1 ; i < list.size() ;i++) {
            if((last + 1) == list.get(i)) {
                len = i - lastIndex + 1;
            } else {
                lastIndex = i;
                len = 1;
            }
            last = list.get(i);
            max = Math.max(max, len);
        }
        return max;
    }
}
