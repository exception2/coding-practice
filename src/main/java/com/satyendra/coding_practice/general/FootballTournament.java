package general;

import java.util.List;

public class FootballTournament {
    public static void main(String[] args) {
        FootballTournament ft = new FootballTournament();
    }

    private int findLeft(List<Integer> list, int key) {
        int low = 0, high = list.size()-1;

        int index = -1;
        while(low < high) {
            int mid = (low + high) / 2;
            if(key == list.get(mid)) {
                index = -1;
            }
        }
        return 1;
    }
}
