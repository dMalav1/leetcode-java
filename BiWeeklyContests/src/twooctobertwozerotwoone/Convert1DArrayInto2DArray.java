package twooctobertwozerotwoone;

import java.util.Arrays;
import java.util.Scanner;

public class Convert1DArrayInto2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int o = sc.nextInt();
            int[] original = new int[o];
            for (int j = 0; j < o; j++) {
                original[j] = sc.nextInt();
            }
            System.out.println(Arrays.deepToString(construct2DArray(original, m, n)));
        }
    }

    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];
        int k = 0;

        if (original.length != m * n) {
            return new int[0][0];
        } else {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    result[i][j] = original[k];
                    k++;
                }
            }
            return result;
        }
    }
}


