/*
TASK: pwrfail
LANG: JAVA
ID: maheshm2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class pwrfail {
    static StreamTokenizer input;
    static double[][] matrix;
    static boolean[][] arr;

    static String[] poles;
    static int n, w;
    static double m;
    public static void main(String[] args) throws IOException {
        String prob = "pwrfail";
//                input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        n = nextInt(); w=nextInt();
        m = nextDouble();
        matrix = new double[n+1][n+1];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = 0;
        poles = new String[n+1];
        for (int i = 1; i <= n; i++) {
            poles[i] = nextInt()+":"+nextInt();
        }
        for (int i = 0; i < w; i++) {
            int a = nextInt();int b = nextInt();double c = dist(a, b);
            matrix[a][b] = c;
            matrix[b][a] = c;
        }
        arr = new boolean[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(path(i, j) == Integer.MAX_VALUE){
                    double aa = dist(i, j);
                    if(aa < m){
                        matrix[i][j] = aa;
                        arr[i][j] = true;
                        arr[j][i] = true;
                    }

                }
            }
        }
        System.out.println((""+1000*path(1, n)).substring(0, 4));
    }
    static double dist(int i, int j){
        int x1 = Integer.parseInt(poles[i].substring(0, poles[i].indexOf(":")));
        int y1 = Integer.parseInt(poles[i].substring(poles[i].indexOf(":")+1));
        int x2 = Integer.parseInt(poles[j].substring(0, poles[i].indexOf(":")));
        int y2 = Integer.parseInt(poles[j].substring(poles[i].indexOf(":") + 1));
        return Math.sqrt((y2-y1)*(y2-y1) + (x2-x1)*(x2-x1));
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
    static double nextDouble() throws IOException {
        input.nextToken();
        return input.nval;
    }
    static double path(int a, int b) {
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        double[] d = new double[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[a] = 0;
        double[] sum = new double[n+1];
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
                        if(!arr[closest][i]) d[i]=0;
                    }
                }
        }
//        if(a==1&&b==9) System.out.println(sum[b]);
        return d[b];
    }
}

