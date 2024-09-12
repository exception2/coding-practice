package wayfair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

// https://leetcode.com/discuss/interview-question/algorithms/4418282/WayFair-Hackerrank-or-SSE-or-Dec-2023/

public class Ipcheck {

    public static void main(String[] args) {
        String range [][]=new String[][]{ {"0.0.0.0","127.255.255.255"}, {"128.0.0.0","128.255.255.255"},
                {"129.0.0.0","129.255.255.255"},{"130.0.0.0","255.255.255.255"} };
        List<String> addresses = new ArrayList<>(Arrays.asList("0.0.0.123","129.234.233.24","256.256.2.1"));
        for(String addr : addresses) {
            long longAddr =  parseIp(addr);
            for (int i = 0; i < 4; i++) {
                System.out.println("ZONE : "+i+" "+(longAddr>=parseIp(range[i][0]) && longAddr<=parseIp(range[i][1])));
            }
        }
    }

    public static long parseIp(String address) {
        long result = 0;

        // iterate over each octet
        for(String part : address.split(Pattern.quote("."))) {
            // shift the previously parsed bits over by 1 byte
            result = result << 8;
            // set the low order bits to the current octet
            result |= Integer.parseInt(part);
        }
        return result;
    }
}
