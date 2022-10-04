import java.util.*;

class Logicmojo{

    static int findWays(int[] num, int k){
        int n = num.length;

        int prev[]=new int[k+1];

        prev[0] =1;

        if(num[0]<=k)
            prev[num[0]] = 1;

        for(int ind = 1; ind<n; ind++){
            int cur[]=new int[k+1];
            cur[0]=1;
            for(int target= 1; target<=k; target++){

                int notTaken = prev[target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = prev[target-num[ind]];

                cur[target]= notTaken + taken;
            }

            prev = cur;
        }

        return prev[k];

    }

    public static void main(String args[]) {

        int arr[] = {2,3,5,6,8,10};
        int k=10;

        System.out.println("The number of subsets found are "+findWays(arr,k));
    }
}