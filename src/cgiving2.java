/*
TASK: cgiving2
LANG: JAVA
ID: maheshm2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class cgiving2 {
    static StreamTokenizer input;
    static int[][] matrix;
    static int n;
    public static void main(String[] args) throws IOException {
        String prob = "cgiving2";
//                input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        n = nextInt(); int m = nextInt(); int b = nextInt();
        matrix = new int[n+1][n+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = nextInt(); int bb = nextInt(); int c = nextInt();
            matrix[a][bb] = c;
            matrix[bb][a] = c;
        }

        for (int i = 0; i < b; i++) {
            int d = path(1, nextInt());
            int d2 = path(1, nextInt());
//            System.out.println(d+":"+d2);
            System.out.println(d+d2);
        }
    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
    static int path(int a, int b) {
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        int[] d = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[a] = 0;
        while (nodes.size() != n) {
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

