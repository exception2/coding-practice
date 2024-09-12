package general;

public class FirstPositiveMissingNumber {
    public static void main(String[] args) {
        FirstPositiveMissingNumber firstPositiveMissingNumber = new FirstPositiveMissingNumber();
        System.out.println(firstPositiveMissingNumber.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(firstPositiveMissingNumber.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstPositiveMissingNumber.firstMissingPositive(new int[]{7,8,9,11, 12}));
    }
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i<nums.length) {
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        for(i = 0; i < nums.length ; i++) {
            if(i + 1 != nums[i]) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
