package me.torabi.maysam;

import android.util.Log;

import java.util.Random;

/**
 * Created by maysam on 5/15/15.
 */
public class MatrixOperations {
    public static int[][] rotateRight(int[][] matrix)
    {
        int w = matrix.length;
        int h = matrix[0].length;
        int[][] ret = new int[h][w];
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                ret[i][j] = matrix[w - j - 1][i];
            }
        }
        return ret;
    }


    public static int[][] rotateLeft(int[][] matrix)
    {
        int w = matrix.length;
        int h = matrix[0].length;
        int[][] ret = new int[h][w];
        for (int i = 0; i < h; ++i) {
            for (int j = 0; j < w; ++j) {
                ret[i][j] = matrix[j][h - i - 1];
            }
        }
        return ret;
    }

    public static  int[][] process(int[][] matrix)
    {
        int w = matrix.length;
        int h = matrix[0].length;
        int[][] ret = new int[w][h];
        Random rand = new Random(System.currentTimeMillis());

        for (int j = 0; j < w; ++j) {
            ret[j] = process_row(matrix[j]);
            if (ret[j][h-1] == 0)
                ret[j][h-1] = rand.nextInt(3)%2;
        }

        return ret;
    }

    private static int[] process_row(int[] row) {
        int[] ret = row.clone();
        int w = 0;
        while(w < row.length-1){
            if ((ret[w] > 0) && (ret[w] == ret[w + 1])) {
                ret[w] = row[w] * 2;
                ret[w+1] = 0;
                w++;
            }
            w++;
        }
        w = 0;
        while (w < row.length) {
            if (ret[w] == 0) {
                int u = w + 1;
                boolean allzero = true;
                while (u < row.length) {
                    if(ret[u]>0)
                        allzero = false;
                    ret[u - 1] = ret[u];
                    u++;
                }
                ret[u - 1] = 0;
                if(allzero)
                    break;
            }
            if (ret[w] > 0) {
                w++;
            }
        }
        return  ret;
    }

    private static String stringify(int[] row) {
        String ret = "";
        for (int i = 0; i < row.length; ++i) {
            ret += String.valueOf(row[i]) + ",";
        }
        return ret;
    }

    public static String stringify(int[][] matrix)
    {
        String ret = "";
        for (int i = 0; i < matrix.length; ++i) {
            ret += '[' + stringify(matrix[i]) + ']';
        }
        return ret;
    }
}
