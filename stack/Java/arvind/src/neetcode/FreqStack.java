package neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreqStack {

    private Map<Integer, Integer> elementCount;
    private int maxCount;
    private Map<Integer, List<Integer>> countList;

    public FreqStack() {
        elementCount = new HashMap<>();
        maxCount = 0;
        countList = new HashMap<>();
    }

    public void push(int val) {
        elementCount.put(val, elementCount.getOrDefault(val, 0) + 1);
        if (!countList.containsKey(elementCount.get(val))) {
            countList.put(elementCount.get(val), new ArrayList<>());
        }
        countList.get(elementCount.get(val)).add(val);
        maxCount = Math.max(maxCount, elementCount.get(val));
    }

    public int pop() {
        int val = countList.get(maxCount).get(countList.get(maxCount).size()-1);
        countList.get(maxCount).remove(countList.get(maxCount).size()-1);
        elementCount.put(val, elementCount.get(val) - 1);
        if (countList.get(maxCount).size() == 0) {
            countList.remove(maxCount);
            maxCount -=1;
        }
        return val;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(4); // The stack is [5]
        freqStack.push(0); // The stack is [5,7]
        freqStack.push(9); // The stack is [5,7,5]
        freqStack.push(3); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(2); // The stack is [5,7,5,7,4,5]
        System.out.println(freqStack.pop());
        freqStack.push(6);// return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        System.out.println(freqStack.pop());
        freqStack.push(1);// return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        System.out.println(freqStack.pop());
        freqStack.push(1);// return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        System.out.println(freqStack.pop());
        freqStack.push(4);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());// return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }
}

