package arvind.neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RandomisedSet {

    private HashMap<Integer, Integer> indexBank;
    private List<Integer> numberList;

    public RandomisedSet() {
        indexBank = new HashMap<>();
        numberList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (indexBank.containsKey(val)) {
            return false;
        }
        // add the value to the list
        int size = numberList.size();
        numberList.add(size, val);
        indexBank.put(val, size);
        return true;
    }

    public boolean remove(int val) {
        if (!indexBank.containsKey(val)) {
            return false;
        }
        // get the current index of the elements
        int ci = indexBank.get(val);
        int size = numberList.size();
        int last = numberList.get(size - 1);
        numberList.set(ci, last);
        indexBank.put(last, ci);

        // remove from both
        numberList.remove(size-1);
        indexBank.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIdx = (int) (Math.random() * numberList.size());
        return numberList.get(randomIdx);
    }

    public static void main(String[] args) {
        RandomisedSet randomizedSet = new RandomisedSet();
        System.out.println(randomizedSet.insert(0)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet.remove(0)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.insert(-1)); // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.

    }
}
