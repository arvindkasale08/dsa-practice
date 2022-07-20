package arvind;

public class BoyrMooreMajorityElement {

    public int findMajority(int[] arr) {
        int count = 1;
        int majority = arr[0];
        for (int a: arr) {
            if (majority == a) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                majority = a;
                count = 1;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        BoyrMooreMajorityElement solution = new BoyrMooreMajorityElement();
        int[] arr = new int[] { 3, 1, 3, 3, 2};
        int majority = solution.findMajority(arr);
        System.out.println("Majority element is "+ majority);
    }
}
