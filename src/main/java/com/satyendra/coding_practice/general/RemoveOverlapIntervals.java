package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RemoveOverlapIntervals {
    public static void main(String[] args) {
        RemoveOverlapIntervals removeOverlapIntervals = new RemoveOverlapIntervals();
        System.out.println(removeOverlapIntervals.eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
        System.out.println(removeOverlapIntervals.eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        int n = intervals.length;
        for(int i = 0 ; i < n ; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }
        Collections.sort(list);
        int count = 0, s1 = list.get(0).start, e1 = list.get(0).end;
        for(int i =1;i<n;i++){
            int s2 = list.get(i).start, e2 = list.get(i).end;
            // not overlap case
            if(e1 <= s2) {
                s1 = s2;
                e1 = e2;
            } else if (e2 <= e1) {
                count++;
                s1 = s2;
                e1 = e2;
            } else {
                count++;
            }
        }
        return count;

    }
    static class Interval implements Comparable<Interval> {
        int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Interval interval) {
            if(this.start == interval.start) {
                return this.end - interval.end;
            }
            return this.start - interval.start;
        }
    }
}
