package general;

import java.util.Scanner;

public class LRRemainders {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n, m;
            n = sc.nextInt();
            m = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            String str = sc.next();
            int[] remainders = calculateRemainders(arr, n, m, str);
            for(int i = 0; i < n; i++) {
                System.out.print(remainders[i] + " ");
            }
            System.out.println();
        }

    }

    private static int[] calculateRemainders(int[] arr, int n, int m, String str) {
        int product = 1;
        int[] remainders = new int[str.length()];
        int left = 0, right = n-1;
        for(int i = 0; i < str.length()-1; i++) {
            char ch = str.charAt(i);
            if( ch == 'L') {
                left++;
            } else if(ch == 'R') {
                right--;
            }
        }
        product = calc(arr,m, left,right);
        for(int i = str.length()-2; i >= 0;i--) {
            remainders[i+1] = product;
            char ch = str.charAt(i);
            if( ch == 'L') {
                product = (product * arr[--left]) % m;
            } else if(ch == 'R') {
                product = (product * arr[++right]) % m;
            }
        }
        remainders[0] = product;
        return remainders;
    }

    private static int calc(int[] arr, int m, int left, int right) {
        int product = 1;
        for(int i = left; i <= right; i++) {
            product = (product * arr[i]) % m;
        }
        return product;
    }
}
