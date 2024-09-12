package adobe;

public class DutchNationalFlagProblem {
    public static void main(String[] args) {
        DutchNationalFlagProblem dutchNationalFlagProblem = new DutchNationalFlagProblem();
        int[] result = dutchNationalFlagProblem.sort012(new int[]{2,1,0,2,1,2,0,1,2});
        for (int i = 0 ; i < result.length ; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    private int[] sort012(int[] arr) {
        int start = 0, mid = 0, end = arr.length - 1;
        while(mid <= end) {
            switch (arr[mid]) {
                case 0:
                    swap(arr, start, mid);
                    start++;mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(arr, mid, end);
                    end--;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
