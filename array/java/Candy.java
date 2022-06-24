public class Candy {
    int candy(int []ratings){
        int left[] = new int[ratings.length];
        int right[] = new int[ratings.length];
        left[0] = 1;
        right[0] = 1;
        for (int i =1; i<ratings.length; i++){
            if (ratings[i] > ratings[i-1]){
                left[i] = left[i-1]+1;
            }else{
                left[i] = 1;
            }
            if (ratings[ratings.length-i-1] > ratings[ratings.length-i]){
                right[i] = right[i-1]+1;
            }else{
                right[i] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i<ratings.length; i++){
            res+=Math.max(left[i],right[ratings.length-i-1]);
        }
        return res;
    }

    public static void main(String[] args){
        Candy c = new Candy();
        int ratings[] = new int[]{1,0,2};
        int res = c.candy(ratings);
        System.out.println("Res: "+res);
    }
}
