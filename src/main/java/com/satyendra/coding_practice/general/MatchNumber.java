package general;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MatchNumber {
    public static void main(String[] args) {
        MatchNumber matchNumber = new MatchNumber();
        System.out.println(matchNumber.minimumOperationsToMakeEqual(1, 4));
        System.out.println(matchNumber.minimumOperationsToMakeEqual(54, 2));
        System.out.println(matchNumber.minimumOperationsToMakeEqual(25, 30));
    }
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y ) return y-x;
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        vis.add(x);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while(size-- != 0) {
                int cell = queue.poll();
                if(cell == y) {
                    return level - 1;
                }
                int mod11 = cell % 11;
                int mod5 = cell % 5;
                int inc1 = cell + 1;
                int dec1 = cell - 1;
                if(mod11 == 0 && cell > y) {
                    int newKey = cell / 11;
                    if(!vis.contains(newKey)) {
                        queue.add(newKey);
                        vis.add(newKey);
                    }
                }
                if (mod5 == 0 && cell > y) {
                    int newKey = cell / 5;
                    if(!vis.contains(newKey)) {
                        queue.add(newKey);
                        vis.add(newKey);
                    }
                }
                if(!vis.contains(inc1)) {
                    queue.add(inc1);
                    vis.add(inc1);
                }
                if(cell > y) {
                    if(!vis.contains(dec1)) {
                        queue.add(dec1);
                        vis.add(dec1);
                    }
                }
            }
        }
        return -1;
    }
}
