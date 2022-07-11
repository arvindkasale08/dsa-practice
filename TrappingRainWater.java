import java.util.*;

public class TrappingRainWater {
    public static int Trapping_Rain_Water(List<Integer> height) {
        // Write your code here
            
            int left[] = new int[ height.size() ];
            int right[] = new int[ height.size() ];
            
            int sum = 0;
            left[0] = height.get( 0);
            right[height.size() - 1] = height.get(height.size() - 1);
            
            for(int i = 1 ; i < height.size() ; i++){
                
                left[i] = Math.max(height.get(i) , left[i - 1]);
            }
            
            for(int j = height.size() - 2 ; j >= 0 ; j--){
                
                right[j] = Math.max(height.get(j) , right[j + 1]);
            }
            
            
            for(int i = 0 ; i < height.size() ; i++){
                
            
                sum  += Math.min(left[i] , right[i]) - height.get(i);
               
            }
            return sum;
}

public static void main(String args[]){

    
    // I have provided the input for this array over here 
    List<Integer> height = new ArrayList<Integer>(Arrays.asList(0 , 1, 0 , 2, 1 , 0 , 1 ,3, 2 ,1 , 2 ,1));
    
    
    System.out.print("Total water Trapped will be : "+Trapping_Rain_Water(height));
}
}
