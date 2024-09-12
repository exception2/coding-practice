package general;

import java.util.*;

public class CountSmaller {
    public static void main(String[] args) {
        CountSmaller countSmaller = new CountSmaller();
        //System.out.println(countSmaller.countSmaller(new int[]{5, 2, 6, 1, 2}));
        //System.out.println(countSmaller.countSmaller(new int[]{-1}));
        //System.out.println(countSmaller.countSmaller(new int[]{-1, -1}));
        System.out.println(countSmaller.countSmaller(new int[]{65, 36, 100, 41}));
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i = n-1;i>=0;i--) {
            Collections.sort(list);
           int index = findSmallerThanK(list, nums[i]);
           if(index == -1) {
               ans.add(0);
           } else {
               ans.add(index + 1);
           }
           addInList(list, nums[i], index);
        }
        Collections.reverse(ans);
        return ans;
    }

    private void addInList(List<Integer> list, int num, int index) {
        if(index == -1) {
            list.add(0, num);
        } else {
            list.add(index+1, num);
        }
    }

    private int findSmallerThanK(List<Integer> arr, int k) {
        int low = 0, high = arr.size() - 1;
        if(arr.isEmpty()) {
            return -1;
        }
        if(k <= arr.get(low)) return -1;
        if(k > arr.get(high)) return high;
        int index = -1;
        while (low <= high) {
            int mid = (low+high)/2;
            if(arr.get(mid) >= k) {
                high = mid-1;
            } else {
                low = mid+1;
                index = mid;
            }
        }
        return index;
    }
}
