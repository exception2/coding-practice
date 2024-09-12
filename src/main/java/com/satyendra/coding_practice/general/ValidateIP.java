package general;

import java.util.regex.Pattern;

public class ValidateIP {

    private final String NEITHER = "Neither";
    private final String IPV4 = "IPv4";
    private final String IPV6 = "IPv6";
    public static void main(String[] args) {
        ValidateIP ip = new ValidateIP();
        System.out.println(ip.validIPAddress("This line has junk text."));
        System.out.println(ip.validIPAddress("121.18.19.20"));
        System.out.println(ip.validIPAddress("121.18.19.2000"));
        System.out.println(ip.validIPAddress("2001:0db8:0000:0000:0000:ff00:0042:8329"));
    }

    private String validIPAddress(String IP) {
        if(IP.chars().filter(ch -> ch == '.').count() == 3) {
            return validateIPv4(IP);
        } else if(IP.chars().filter(ch -> ch == ':').count() == 7) {
            return validateIPv6Address(IP);
        } else {
            return NEITHER;
        }
    }

    private String validateIPv6Address(String ip) {
        String regex = "(([A-Z0-9a-z]){1,4}\\:){7}([A-Z0-9a-z]){1,4}";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(ip).matches()) return IPV6;
        return NEITHER;
    }

    private String validateIPv6(String ip) {
        String[] arr = ip.split(":");
        for (String s : arr) {
            if(s.isEmpty() || s.length() > 4) {
                return NEITHER;
            }
            for (char ch : s.toCharArray()) {
                if(!Character.isDigit(ch) && (ch < 'a' || ch > 'f')) {
                    return NEITHER;
                }
            }
        }
        return IPV6;
    }

    private String validateIPv4(String ip) {
        String[] arr = ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            int len = arr[i].length();
            if(len == 0 || len > 3) {
                return NEITHER;
            }
            int number = Integer.parseInt(arr[i]);
            if(len ==1 && number >= 0 && number <= 9) {
                continue;
            } else if(len == 2 && number >= 10 && number <= 99) {
                continue;
            } else if(len == 3 && number >= 100 && number <= 255) {
                continue;
            } else {
                return NEITHER;
            }
        }
        return IPV4;
    }
}
