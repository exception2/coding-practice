package general;

import java.util.Random;

public class Shuffle {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Shuffle s = new Shuffle(nums);
        int[] shuffle1 = s.shuffle();
        for (int i = 0; i < shuffle1.length; i++) {
            System.out.print(shuffle1[i] + " ");
        }
        System.out.println();
        int[] reset1 = s.reset();
        for (int i = 0; i < reset1.length; i++) {
            System.out.print(reset1[i] + " ");
        }
        System.out.println();
        int[] shuffle2 = s.shuffle();
        for (int i = 0; i < shuffle2.length; i++) {
            System.out.print(shuffle2[i] + " ");
        }
        System.out.println();

    }
    int[] original;
    int[] arr;
    Random r = new Random();
    public Shuffle(int[] nums) {
        this.arr = nums.clone();
        this.original = nums.clone();
    }

    public int[] reset() {
        arr = original.clone();
        return arr;
    }

    public int[] shuffle() {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int randomNumber = r.nextInt(n);
            int tmp = arr[i];
            arr[i] = arr[randomNumber];
            arr[randomNumber] = tmp;
        }
        return arr;
    }
}
