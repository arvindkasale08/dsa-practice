package arvind;

import java.util.Arrays;

public class CountFrequencyInPlace {

    // BF Solution is to use a seperate array and then return it

    public int[] frequencyBF(int[] arr) {
        int[] result = new int[arr.length];

        for (int i=0; i<arr.length; i++) {
            result[arr[i]-1] +=1;
        }

        return result;
    }

    public int[] frequency(int[] arr) {
        int n = arr.length;
        // reduce all elements by 1
        for (int i=0; i< arr.length; i++) {
            arr[i] -= 1;
        }

        // Catch occurences at mod indexes
        for (int i=0; i< arr.length; i++) {
            int idx = arr[i] % n;
            arr[idx] = arr[idx] + n;
        }

        // Divide by n to get occurences
        for (int i=0; i<arr.length; i++) {
            arr[i]/=n;
        }

        return arr;
    }

    public void display(int[] arr) {
        for (int a : arr) {
            System.out.print(" "+ a);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        CountFrequencyInPlace solution = new CountFrequencyInPlace();
        int[] arr = new int[] {2, 3, 2, 3, 5};
        int[] result = solution.frequency(arr);
        solution.display(result);
    }
}
