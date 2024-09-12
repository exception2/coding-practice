package general;

import java.util.*;

public class TrianglePyramid {
    public static void main(String[] args) {
        System.out.println(pyramidTransition("BCD", List.of("BCC", "CDE", "CEA", "FFF")));
        System.out.println(pyramidTransition("AAAA", List.of("AAB", "AAC", "BCD", "BBE", "DEF")));
    }

    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        Set<String> allowedSet = new HashSet<>(allowed);
        char[] charSet = {'A', 'B', 'C', 'D', 'E', 'F'};
        // return nextBottomUtil(bottom, allowedSet,  bottom.length() - 1, set);
        return nextBottomUtil(bottom, allowedSet, charSet, "", bottom.length() - 1, 0);
    }

    static boolean nextBottomUtil(String bottom, Set<String> allowed, char[] charSet, String prefix, int k, int j) {
        if (k == 0) {
            return true;
        } else if (k == j) {
            //System.out.println(prefix);
            return checkAllowed(bottom, prefix, allowed) && nextBottomUtil(prefix, allowed, charSet, "", k - 1, 0);
        }
        for (char c : charSet) {
            String newPrefix = prefix + c;
            if (nextBottomUtil(bottom, allowed, charSet, newPrefix, k, j + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkAllowed(String bottom, String nextBottom, Set<String> allowedSet) {
        List<String> new_list = new ArrayList<>();
        for (int i = 0; i < nextBottom.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(bottom.charAt(i));
            sb.append(bottom.charAt(i + 1));
            sb.append(nextBottom.charAt(i));

            new_list.add(sb.toString());
        }
        for (String str : new_list) {
            if (!allowedSet.contains(str)) {
                return false;
            }
        }
        return true;
    }
}