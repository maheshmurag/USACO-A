/*
TASK: sparty
LANG: JAVA
ID: maheshm2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class sparty {
    static int[][] matrix;
    static int n, m, x;
    static StreamTokenizer input;

    public static void main(String[] args) throws IOException {
        String prob = "sparty";
//        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        n = nextInt();
        m = nextInt();
        x = nextInt();
        matrix = new int[n + 1][n + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++)
            matrix[nextInt()][nextInt()] = nextInt();
//        printArr(matrix);
//        System.out.println(path(4, 2));
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int aa = path(i, x);
            int bb = path(x, i);
            if(aa+bb> max) max = aa+bb;
        }
        System.out.println(max);
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }

    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int path(int a, int b) {
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[a] = 0;
        int counter = 0;
        while (nodes.size() != n) {
            counter++;
            int closest = b;
            for (int i = 1; i <= n; i++) {
                if (d[i] < d[closest] && !nodes.contains(i)) {
                    closest = i;
                }
            }
            nodes.add(closest);
            for (int i = 1; i <= n; i++)
                if (matrix[closest][i] != 0 && !nodes.contains(i)) {
                    if (d[closest] + matrix[closest][i] < d[i]) {
                        d[i] = matrix[closest][i] + d[closest];
                    }
                }
        }
        return d[b];
    }
}

