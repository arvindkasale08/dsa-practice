package practice2;

public class MajorityElement {

    public int findMajorityElement(int[] arr) {
        int count = 1;
        int majority = arr[0];

        for (int i=1; i< arr.length; i++) {
            if (arr[i] == majority) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majority = arr[0];
                count = 1;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        MajorityElement solution = new MajorityElement();
        int[] arr = new int[] {2, 2, 1, 1, 1, 2, 2};
        // expected answer is 2
        int result = solution.findMajorityElement(arr);
        System.out.println("Majority element is "+ result);
    }
}
