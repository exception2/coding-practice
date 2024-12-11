package com.satyendra.coding_practice.inmobi;

public class HappyNumber {
    /*
    input -> 19
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1
    Output: true

    2
    4
    16
    1 + 36 = 37
    9 + 49 = 58
    25 + 64 = 89
    64 + 81 = 145


    1
    10 -> 1, 9 = 13 = 4 + 9 = 23
    100
    1000

    19 -> 1 , 9
    4 -> 16 -> 1 + 36 = 37 -> 9 + 49 = 58 -> 25 + 64 ->  89 -> 64 + 81 -> 145 -> 1 + 16 + 25 = 42 -> 16 + 4 = 20 = 4

 com.satyendra.coding_practice.inmobi.Solution 1:
    19
    num =
    while(num != 1) {
    }
    * */

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.checkOne(19));
        System.out.println(happyNumber.checkOne(2));
        System.out.println(happyNumber.checkOne(4));
        System.out.println(happyNumber.checkOne(0));
        System.out.println(happyNumber.checkOne(1));


    }

    private boolean checkOne(int n) {
        int originalNum = n;
        if(n == 1) {
            return true;
        }
        n = squareAndAdd(n);
        while(n != originalNum) {
            n = squareAndAdd(n);
            if(n==1) {
                return true;
            }
        }
        return false;
    }

    private int squareAndAdd(int n) {
        int res = 0;
        while (n > 0) {
            int rem = n % 10;
            res += (Math.pow(rem, 2));
            n /= 10;
        }
        return res;
    }

    /*
              1
       2            3
    4     5      6      7
  8  9  10 11  12 13  14  15

  Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
    * */
}
