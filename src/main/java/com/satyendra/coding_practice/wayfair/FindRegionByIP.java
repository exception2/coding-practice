package wayfair;

// https://leetcode.com/discuss/interview-question/algorithms/4418282/WayFair-Hackerrank-or-SSE-or-Dec-2023/
public class FindRegionByIP {
    public static void main(String[] args) {
        FindRegionByIP findRegionByIP = new FindRegionByIP();
        int[] ans1 = findRegionByIP.findRegionByIP(new String[]{"0.0.0.123","129.234.233.24","256.256.2.1"});
        for (int i = 0; i < ans1.length; i++) {
            System.out.print(ans1[i] + " ");
        }
        System.out.println();
        int[] ans2 = findRegionByIP.findRegionByIP(new String[]{"ab1.0.0.123","129.234.233.24","251.x56.2.1"});
        for (int i = 0; i < ans2.length; i++) {
            System.out.print(ans2[i] + " ");
        }
        System.out.println();
    }
    private int[] findRegionByIP(String[] ips) {
        int[] ans = new int[ips.length];
        for(int i = 0; i < ips.length; i++) {
            if(validateIP(ips[i])) {
                String[] parts = ips[i].split("\\.");
                int firstOctet = Integer.parseInt(parts[0]);
                ans[i] = getRegion(firstOctet);
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
    private boolean validateIP(String str) {
        if(str.chars().filter(ch -> ch == '.').count() != 3) {
            return false;
        }
        String[] parts = str.split("\\.");
        if(parts.length != 4) {
            return false;
        }
        for(String part : parts) {
            if(part.isEmpty() || part.length() > 3 || part.charAt(0) == '-') {
                return false;
            }
            if(part.charAt(0) == '0' && part.length() > 1) {
                return false;
            }
            try {
                int num = Integer.parseInt(part);
                if(num < 0 || num > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
    private int getRegion(int firstOctet) {
        if(firstOctet >= 0 && firstOctet <= 127) {
            return 1;
        } else if(firstOctet >= 128 && firstOctet <= 191) {
            return 2;
        } else if(firstOctet >= 192 && firstOctet <= 223) {
            return 3;
        } else if(firstOctet >= 224 && firstOctet <= 239) {
            return 4;
        } else if(firstOctet >= 240 && firstOctet <= 255) {
            return 5;
        }
        return -1;
    }
}
