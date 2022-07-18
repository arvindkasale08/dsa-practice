package arvind;

public class FindElementOnceEverythingElseThrice {

    public int findElement(int[] arr) {
        int tn= Integer.MAX_VALUE, tnp1 = 0, tnp2 = 0;

        for (int a : arr) {
            int cwtn = tn & a;
            int cwtnp1 = tnp1 & a;
            int cwtnp2 = tnp2 & a;

            tn = tn & (~cwtn); // unset in tn
            tnp1 = tnp1 | cwtn; // set in tnp1

            tnp1 = tnp1 & (~cwtnp1); // unset in tnp1
            tnp2 = tnp2 | cwtnp1; // set in tnp2

            tnp2 = tnp2 & (~cwtnp2); // unset in tnp2
            tn = tn | cwtnp2; // set in tn
        }
        return tnp1;
    }

    public static void main(String[] args) {
        FindElementOnceEverythingElseThrice solution = new FindElementOnceEverythingElseThrice();
        int[] arr = new int[] {1, 10, 1, 1};
        int result = solution.findElement(arr);
        System.out.println("The element is "+ result);
    }
}
