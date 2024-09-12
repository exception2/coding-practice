package general;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SuperiorString {
    public static void main(String[] args) {
        SuperiorString ss = new SuperiorString();
        System.out.println(ss.superString("piz", "bug"));
        System.out.println(ss.superString("bea", "dac"));
        System.out.println(ss.superString("PCOMCTU", "OCOMOOU"));
    }

    private boolean superString(String s1, String s2) {

        s1 = Stream.of(s1.split("")).sorted().collect(Collectors.joining());
        s2 = Stream.of(s2.split("")).sorted().collect(Collectors.joining());

        if(findMatch(s1, s2) || findMatch(s2, s1)) {
            return true;
        }
        return false;
    }

    private boolean findMatch(String s1, String s2) {
        for(int i =0; i< s1.length();i++) {
            if(s1.charAt(i) < s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

}
