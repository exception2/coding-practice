package general;

import java.util.ArrayList;
import java.util.List;

public class DoorSort {
    public static void main(String[] args) {
        System.out.println(solution(List.of(100, 200, 300, 500), List.of(5, 6, 8, 3)));
    }
    static String solution(List<Integer> Narr, List<Integer> Darr ) {
        int num = -1;
        int dist = Integer.MAX_VALUE;
        List<Integer> arr = List.of(100, 200, 300, 500);
        for (int i = 0; i < 4; i++) {
            if(Narr.get(i) < arr.get(i)) {
                if(dist > Darr.get(i)) {
                    dist = Darr.get(i);
                    num = i;
                }
            }
        }
        if(num == -1) {
            return "EXIT";
        } else if(num == 0) {
            return "B1";
        } else if(num == 1) {
            return "B2";
        } else if(num == 2) {
            return "B3";
        } else {
            return "B4";
        }
    }
}
