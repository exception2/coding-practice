package general;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        ReorganizeString rs = new ReorganizeString();
        System.out.println(rs.reorganizeString("vvvlo"));
    }
    public String reorganizeString(String s) {
        int maxCount = 0;
        int n = s.length();
        int[] map = new int[26];
        for(char c : s.toCharArray()) {
            map[c-'a']++;
            maxCount = Math.max(maxCount, map[c-'a']);
        }
        if(maxCount > (n-maxCount+1)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComaparator());
        for(int i =0 ; i < 26 ;i++) {
            if(map[i]>0) {
                pq.add(new Pair((char)(i+'a'), map[i]));
            }
        }
        while(!pq.isEmpty()) {
            if(pq.size()>=2) {
                Pair p1 = pq.poll();
                Pair p2 = pq.poll();
                if(--p1.count > 0) {
                    pq.add(new Pair(p1.ch, p1.count));
                }
                if(--p2.count > 0) {
                    pq.add(new Pair(p2.ch, p2.count));
                }

                if(sb.length() == 0 || sb.charAt(sb.length()-1) != p1.ch) {
                    sb.append(p1.ch);
                    sb.append(p2.ch);
                } else {
                    sb.append(p2.ch);
                    sb.append(p1.ch);
                }
            } else {
                Pair p = pq.poll();
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
    static class PairComaparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return p2.count - p1.count;
        }
    }
    static class Pair {
        char ch;
        int count;
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
