package com.arvind.revision.warmup;

public class FlippingImage {

    public int[][] flipAndInvertImage(int[][] image) {
        int rows = image.length;
        int cols = image[0].length;

        for (int i=0; i< rows; i++) {
                int l = 0, r = cols - 1;
                while (l <= r) {
                    int temp = image[i][l];
                    image[i][l] = invert(image[i][r]);
                    image[i][r] = invert(temp);
                    l++;
                    r--;
                }
        }
        return image;
    }

    private int invert(int x) {
        return x == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };

        FlippingImage solution = new FlippingImage();
        arr = solution.flipAndInvertImage(arr);
        for (int i=0; i< arr.length; i++) {
            for (int j=0; j<arr[0]. length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("\n----------------");
        }
    }
}
