package general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RankTeamByVote {

    public static void main(String[] args) {
        RankTeamByVote rankTeamByVote = new RankTeamByVote();
        String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
        System.out.println(rankTeamByVote.rankTeams(votes));
    }

    public String rankTeams(String[] votes) {
        int n = votes.length;
        int m = votes[0].length();
        List<Node> list = new ArrayList<>();
        for(int i = 0 ;i < 26 ; i++) {
            list.add(new Node(0, (char)('A' + i)));
        }

        for(int i = 0 ; i < n ; i++) {
            double rank = 1.0;
            String vote = votes[i];
            for(int j = 0 ; j < m ; j++) {
                char ch = vote.charAt(j);
                Node node = list.get(ch - 'A');
                node.rank += rank;
                rank /= (n+1);
            }
        }

        Collections.sort(list);
        String ans = "";
        for(int i = 0 ; i < m ; i++) {
            ans += list.get(i).candidate;
        }
        return ans;
    }

    static class Node implements Comparable<Node>{
        double rank;
        char candidate;

        public Node(double rank, char candidate) {
            this.rank = rank;
            this.candidate = candidate;
        }

        public int compareTo(Node node) {
            if(Double.compare(this.rank, 0.0) == 0) {
                return 1;
            }
            else if(Double.compare(this.rank, node.rank) > 0) {
                return -1;
            }
            else if(Double.compare(this.rank, node.rank) < 0) {
                return 1;
            } else {
                return this.candidate - node.candidate;
            }
        }
    }
}
