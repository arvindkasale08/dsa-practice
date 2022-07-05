import java.util.Arrays;

public class MinimumPlatforms {
    int minimumPlatforms(int arr[], int dep[]){
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int curPlat = 0;
        int maxPlat = 0;
        
        int i = 0;
        int j = 0;

        while(i<arr.length){
            if (arr[i] > dep[j]){
                j+=1;
                i+=1;
            }else{
                curPlat += 1;
                if (curPlat>maxPlat){
                    maxPlat = curPlat;
                }
                i+=1;
            }
        }
        return maxPlat;
    }

    public static void main(String[] args){
        MinimumPlatforms mp = new MinimumPlatforms();
        //int arr[] = new int[]{900, 940, 950, 1100, 1500, 1800};
        //int dep[] = new int[]{910, 1200, 1120, 1130, 1900, 2000};

        int arr[] = new int[]{800, 1100};
        int dep[] = new int[]{1200, 1500};

        System.out.println(mp.minimumPlatforms(arr, dep));
    }
}
