package general;

import java.util.*;

public class PhoneLetterCombination {

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        List<String> ans = new ArrayList<>();

        feedData(digits, "", 0, map, ans);
        return ans;
    }
    private void feedData(String digits, String str, int index, Map<Integer, List<Character>> map , List<String> ans) {
        if(str.length() == digits.length()) {
            ans.add(str);
            return;
        }
        List<Character> list = map.get(digits.charAt(index) - '0');
        for(int i = 0 ; i < list.size(); i++) {
            feedData(digits, str + list.get(i), index + 1, map, ans);
        }
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0 ; i<m ; i++) {
            for(int j = 0; j <n ; j++) {
                int top = -1, left = -1;
                if(i-1 >= 0) {
                    top = grid[i-1][j];
                }
                if(j - 1 >= 0) {
                    left = grid[i][j-1];
                }
                if(top != -1 && left != -1) {
                    grid[i][j] += Math.min(top, left);
                    continue;
                }
                if(top != -1) {
                    grid[i][j] += top;
                }
                else if(left != -1) {
                    grid[i][j] += left;
                }
            }
        }
        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        PhoneLetterCombination plc = new PhoneLetterCombination();
        //System.out.println(plc.letterCombinations("6"));
        System.out.println(plc.minPathSum(new int[][]{{1,3,1}, {1, 5, 1}, {4,2,1}}));
    }
}
