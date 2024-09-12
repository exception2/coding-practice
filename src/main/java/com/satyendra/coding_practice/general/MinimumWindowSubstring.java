package general;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(m.minWindow("a", "a"));
        System.out.println(m.minWindow("a", "aa"));
        System.out.println(m.minWindow("cabwefgewcwaefgcf", "cae"));
    }

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] tmap = new int[256];
        int[] smap = new int[256];
        for(char ch : t.toCharArray()) {
            tmap[ch]++;
        }
        int left = 0;
        int startIndex = -1;
        int len = m;
        for(int i = 0 ;i < m ; i++) {
            char ch = s.charAt(i);
            smap[ch]++;
            if(isMatch(smap, tmap)) {
                if(len >= i - left + 1) {
                    len = i - left + 1;
                    startIndex = left;
                }
                smap[s.charAt(left++)]--;
                while(isMatch(smap, tmap)) {
                    smap[s.charAt(left)]--;
                    if(len >= i -left+1) {
                        len = i - left + 1;
                        startIndex = left;
                    }
                    left++;
                }
                smap[s.charAt(--left)]++;
            }
        }
        if(startIndex == -1) return "";
        return s.substring(startIndex, startIndex+len);
    }
    private boolean isMatch(int[] map1, int[] map2) {
        for(int i =0 ;i < 256; i++) {
            if(map2[i] > map1[i]) {
                return false;
            }
        }
        return true;
    }
}
