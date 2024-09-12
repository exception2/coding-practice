package general;

import com.sun.source.tree.Tree;

import java.util.*;

public class FindMinimum {
    public static void main(String[] args) {
        System.out.println(findSmallest(new int[]{1, 2, 5, 9, 12, 17, 21}, 8));
        System.out.println(findSmallest(new int[]{1, 2, 5, 9, 12, 17, 21}, -2));
        System.out.println(findSmallest(new int[]{1, 2, 5, 9, 12, 17, 21}, 23));
        System.out.println(findSmallest(new int[]{1}, 3));
        System.out.println(findSmallest(new int[]{10, 20}, 15));
    }

    private static int findSmallest(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        if(high == 0 && arr[low] <= key) return arr[low];
        if(key >= arr[high]) return arr[high];
        int key_index = -1;
        while(low <= high) {
            int mid = (low+high)/ 2;
            if(arr[mid] == key) {
                key_index = mid;
                break;
            } else {
                if(arr[mid] > key) {
                    high = mid-1;
                } else {
                    low = mid+1;
                    key_index = mid;
                }
            }
        }
        return key_index == -1 ? -1 : arr[key_index];
    }
}

class TimeMap {

    Map<String, Map<Integer, String>> timeMap;
    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, val -> new TreeMap<>());
        Map<Integer, String> map = timeMap.get(key);
        map.put(timestamp, value);
    }

    public String get(String key, int timestamp) throws Exception {
        Map<Integer, String> map = timeMap.get(key);
        List<Integer> keys = new ArrayList<>(map.keySet());
        int result = findSmallest(keys, timestamp);
        if(result != -1) {
            return map.get(result);
        } else {
            throw new Exception("Not valid timestamp");
        }
    }
    private int findSmallest(List<Integer> arr, int key) {
        int low = 0, high = arr.size() - 1;
        int key_index = -1;
        while(low < high) {
            int mid = (low+high)/ 2;
            if(arr.get(mid) == key) {
                key_index = mid;
                break;
            } else {
                if(arr.get(mid) > key) {
                    high = mid-1;
                } else {
                    low = mid+1;
                    key_index = mid + 1;
                }
            }
        }
        return key_index == -1 ? -1 : arr.get(key_index);
    }
}
