public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] arr) {
        int count = 0;
        int noOfConsecutiveOnes = -1;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 1){
                count++;
            }
            if(arr[i] == 0){
                count = 0;
            }
            noOfConsecutiveOnes = Math.max(noOfConsecutiveOnes,  count);
        }
        return noOfConsecutiveOnes;
    }    

    public static void main(String[] args){
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
        int arr[] = {1,0,1,1,1,0,1};
        int count = mco.findMaxConsecutiveOnes(arr);
        System.out.println("Count: "+count);
    }
}
