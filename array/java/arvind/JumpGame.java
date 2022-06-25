package arvind;

public class JumpGame {

    public int solve(int[] arr) {

        int a = arr[0];
        int b = arr[0];
        int n = arr.length;
        int jumps = 0;

        for (int i=1; i < n; i++) {
            a-=1;
            b-=1;
            b = Math.max(b, arr[i]);

            if (i == n-1 || a == 0) {
                a = b;
                jumps++;
            }

            if (b == 0) {
                // cant be 0
                return -1;
            }
        }


        return jumps;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int arr[] = new int[] {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int jumps = jumpGame.solve(arr);
        System.out.println("Number of jumps needed is "+ jumps);

        int arr2[] = new int[] {1, 2, 3, 4, 5};
        int jumps2 = jumpGame.solve(arr2);
        System.out.println("Number of jumps needed is "+ jumps2);

        int arr3[] = new int[] {2, 1, 0, 4};
        int jumps3 = jumpGame.solve(arr3);
        System.out.println("Number of jumps needed is "+ jumps3);
    }
}
