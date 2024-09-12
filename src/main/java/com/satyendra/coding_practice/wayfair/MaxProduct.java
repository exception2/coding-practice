package wayfair;

public class MaxProduct {

    public static void main(String[] args) {
        MaxProduct mp = new MaxProduct();
        System.out.println(mp.findMaxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(mp.findMaxProduct(new int[]{2, -3, 2, 4, -1}));
    }

    private int findMaxProduct(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int maxProd = nums[0] , minProd = nums[0], prod = nums[0];
        int lastIndex = 0;
        for(int i=1;i<n;i++) {
            int temp = Math.max(nums[i], Math.max(nums[i]*maxProd, nums[i]*minProd));
            minProd = Math.min(nums[i], Math.min(nums[i]*maxProd, nums[i]*minProd));
            maxProd = temp;
            if(maxProd > prod) {
                prod = maxProd;
                lastIndex = i;
            }
        }
        int startIndex = lastIndex;
        int tempProd = nums[startIndex];;
        while(tempProd < prod) {
            startIndex--;
            tempProd = tempProd * nums[startIndex];
        }
        System.out.println("Start index : " + startIndex + " & last Index : " + lastIndex);
        return prod;
    }
}
