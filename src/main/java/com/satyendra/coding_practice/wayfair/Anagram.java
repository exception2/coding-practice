package wayfair;

import java.util.*;

public class Anagram {

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        List<String> words = new ArrayList<>(List.of("cat","act","allot","peach","cheap","dusty"));
        List<String> queries = new ArrayList<>(List.of("study","peahc","tac"));
        System.out.println(solve(words, queries));
        //List<List<String>> list1 = anagram.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        //System.out.println(list1);
        List<String> words1 = new ArrayList<>(List.of("duel","speed","dule","cars"));
        List<String> queries1 = new ArrayList<>(List.of("spede","deul"));
        System.out.println(solve(words1, queries1));
    }

    private static List<List<String>> solve(List<String> words,List<String> queries){
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> store = new HashMap<>();
        for (String word: words) {
            String hash = getHash(word);
            store.putIfAbsent(hash,new ArrayList<>());
            store.get(hash).add(word);
        }

        for (String word: queries) {
            String hash = getHash(word);
            if(store.containsKey(hash)){
                List<String> curAns = store.get(hash);
                Collections.sort(curAns);
                ans.add(curAns);
            }else{
                ans.add(Collections.emptyList());
            }
        }

        return ans;
    }

    private static String getHash(String word){
        char[] arr = word.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

}
