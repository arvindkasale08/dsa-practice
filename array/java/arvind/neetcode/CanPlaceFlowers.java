package arvind.neetcode;

public class CanPlaceFlowers {

    public boolean canPlaceFlower(int[] flowerbed, int n) {
        for (int i=0; i<flowerbed.length; i++) {
            int left = i == 0 ? 0 : flowerbed[i-1];
            int mid = flowerbed[i];
            int right = i == flowerbed.length - 1 ? 0 : flowerbed[i+1];
            if (mid == 0 && left == 0 && right == 0) {
                flowerbed[i] = 1;
                n--;
            }

            if (n == 0)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0, 0, 0};
        int n = 2;
        CanPlaceFlowers solution = new CanPlaceFlowers();
        boolean result = solution.canPlaceFlower(flowerbed, n);
        System.out.println(result);
    }
}
