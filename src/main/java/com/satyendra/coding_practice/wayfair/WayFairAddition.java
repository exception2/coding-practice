package wayfair;

public class WayFairAddition {
    public static void main(String[] args) {
        WayFairAddition wayFairAddition = new WayFairAddition();
        System.out.println(wayFairAddition.addTwoNumbers("92", "981"));
        System.out.println(wayFairAddition.addTwoCommaSeparatedNumbers("91", "943"));
        System.out.println(wayFairAddition.addTwoCommaSeparatedNumbers("2,911", "43"));
        System.out.println(wayFairAddition.fabonacci(600));
    }

    private String fabonacci(int n) {
        if(n==0) return "";
        if(n==1 || n==2) return "1";

        String a = "1", b="1";
        for(int i=3;i<=n;i++) {
            String c = addTwoCommaSeparatedNumbers(a, b);
            a = b;
            b=c;
        }
        return b;
    }

    private String addTwoCommaSeparatedNumbers(String num1, String num2) {
        num1 = num1.replaceAll(",", "");
        num2 = num2.replaceAll(",", "");
        String sum = addTwoNumbers(num1, num2);
        return makeCommaSeparatedBeauty(sum);
    }

    private String makeCommaSeparatedBeauty(String sum) {
        StringBuilder sb = new StringBuilder();
        int sp=0;
        for (int i = sum.length() - 1; i >= 0; i--) {
            sp++;
            sb.append(sum.charAt(i));
            if(sp%3==0 && i != 0){
                sb.append(',');
            }
        }
        return sb.reverse().toString();
    }

    private String addTwoNumbers(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(j) - '0';
            int sum = a + b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        while (i >= 0) {
            int a = num1.charAt(i) - '0';
            int sum = a + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
        }
        while (j >= 0) {
            int b = num2.charAt(j) - '0';
            int sum = b + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
