package wayfair;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubSequence {
    static final int M = 1000000007;

    public static void main(String[] args) {
        System.out.println(solution("abca"));
        System.out.println(solution("abc"));
    }

    static int add(int x, int y) {
        x += y;
        if (x >= M) {
            x -= M;
        }
        return x;
    }
    static int sub(int x, int y) {
        x -= y;
        if (x < 0) {
            x += M;
        }
        return x;
    }
    static int solution(String s) {
        if (s.isEmpty()) return 0;
        int n = s.length();
        int[] end = new int[n];
        end[0] = 1;
        Map<Character, Integer> last = new HashMap<>();
        int sum = 1;
        for (int i = 1; i < n; ++i) {
            end[i] = sub(sum, end[i - 1]);
            if (last.containsKey(s.charAt(i - 1))) {
                end[i] = add(end[i], end[last.get(s.charAt(i - 1))]);
            }
            end[i] = add(end[i], 1);
            last.put(s.charAt(i - 1), i - 1);
            if (last.containsKey(s.charAt(i))) {
                sum = sub(sum, end[last.get(s.charAt(i))]);
            }
            sum = add(sum, end[i]);
        }
        return sum;
    }
}

