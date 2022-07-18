package arvind;

public class FindRepeatingWhenEverythingElseTwice {

    public int findNonRepeating(int[] arr) {
        int tn = Integer.MAX_VALUE, tnp1 = 0;

        for (int a : arr) {
            int cwtn = tn & a;
            int cwtn1 = tnp1 & a;

            tn = tn & (~cwtn);
            tnp1 = tnp1 | cwtn;

            tnp1 = tnp1 & (~cwtn1);
            tn = tn | cwtn1;
        }
        return tnp1;
    }

    public static void main(String[] args) {
        FindRepeatingWhenEverythingElseTwice solution = new FindRepeatingWhenEverythingElseTwice();
        int[] arr = new int[] {2, 2, 4, 4, 7, 7, 9, 9, 11};
        int result = solution.findNonRepeating(arr);
        System.out.println("Single element is "+ result);
    }
}
