package arintra;

import java.util.*;

public class RandomSetImpl implements RandomSet {

    Map<Integer, Integer> mapSet;
    List<Integer> listSet;
    int size;
    Random random;
    public void initialize() {
        mapSet = new HashMap<>();
        listSet = new ArrayList<>();
        size = 0;
        random = new Random();
    }

    public boolean insert(int val) {
        if(mapSet.containsKey(val)) {
            return false;
        }
        listSet.add(val);
        mapSet.put(val, size);
        size++;
        return true;
    }

    public boolean delete(int val) {
        if(!mapSet.containsKey(val)) {
            return false;
        }
        int deletedIndex = mapSet.get(val);
        if(size == 1) { // only one element
            mapSet.remove(val);
            listSet.clear();
            size = 0;
        } else if(deletedIndex == size - 1) {
            mapSet.remove(val);
            listSet.remove(Integer.valueOf(val)); //
            size--;
        } else {

            int swapEnd = listSet.get(size-1);
            // int swapMid = listSet.get(deletedIndex);
            listSet.set(deletedIndex, swapEnd);
            mapSet.put(swapEnd, deletedIndex);
            listSet.remove(Integer.valueOf(val));
            mapSet.remove(val);
            size--;
        }
        return true;
    }

    public int getRandom() {
        return listSet.get(random.nextInt(0, size));
    }
}
