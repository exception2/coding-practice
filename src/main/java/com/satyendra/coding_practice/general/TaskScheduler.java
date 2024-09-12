package general;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        System.out.println(taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(taskScheduler.leastInterval(new char[]{'A','C','A','B','D','B'}, 1));
        System.out.println(taskScheduler.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3));
    }
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int maxVal = map[25] - 1, idleSlots = maxVal * n;
        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(map[i], maxVal);
        }
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}
