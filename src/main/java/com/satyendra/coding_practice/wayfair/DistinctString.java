package wayfair;
//https://leetcode.com/discuss/interview-question/4269180/Wayfair-OA

public class DistinctString {
    /*
    const int M = 1000000007;

int add(int x, int y) {
    if ((x += y) >= M) {
        x -= M;
    }
    return x;
}

int sub(int x, int y) {
    if ((x -= y) < 0) {
        x += M;
    }
    return x;
}

int solution(const string &s) {
    if (s.empty()) return 0;
    const int n = s.length();
    // The number of valid subsequences ending with character s[i] (note the character is s[i]
    // but the index may be different.
    vector<int> end(n);
    end[0] = 1;
    unordered_map<char, int> last;
    int sum = 1;
    for (int i = 1; i < n; ++i) {
        end[i] = sub(sum, end[i - 1]);
        if (last.count(s[i - 1])) {
            end[i] = add(end[i], end[last[s[i - 1]]]);
        }
        end[i] = add(end[i], 1);
        last[s[i - 1]] = i - 1;
        if (last.count(s[i])) {
            sum = sub(sum, end[last[s[i]]]);
        }
        sum = add(sum, end[i]);
    }
    return sum;
}
     */
}
