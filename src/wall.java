/*
TASK: wall
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class wall {
    static StreamTokenizer input;
    static int[][] matrix;
    static Node[] dist;
    static int h,f;
    public static void main(String[] args) throws IOException {
        String prob = "wall";
//        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        h = nextInt();f=nextInt();
        matrix = new int[f+2][f+2];
        dist = new Node[f+1];
        for (int i = 1; i < f+1; i++)
            dist[i] = new Node(nextInt(), nextInt());
        for (int i = 1; i < f+1; i++) {
            for (int j = i+1;j< f+1;j++){
                if(close(i, j)) {
                    matrix[i][j] = 1;
                    matrix[j][i] = 1;
                }
            }
            if(dist[i].y > h-1000){
                matrix[i][f+1] = 1;
                matrix[f+1][i] = 1;
            }
            if(dist[i].y < 1000){
                matrix[i][0] = 1;
                matrix[0][i] = 1;
            }
        }
//        print2Arr(matrix);
        System.out.println(path());
    }

    static void print2Arr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int path() {
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        int[] d = new int[f + 2];
        int a = 0; int b = f + 1;
        Arrays.fill(d, Integer.MAX_VALUE);
        d[a] = 0;
        int count = 0;
        while (nodes.size() != f) {
            int closest = b;
            for (int i = 0; i <= f+1; i++) {
                if (d[i] < d[closest] && !nodes.contains(i)) {
                    closest = i;
                }
            }
            nodes.add(closest);
            for (int i = 0; i <= f+1; i++) {
//                System.out.println("fdosianfodisan("+closest+":"+i+")" + ":" + matrix[closest][i]);
                if (matrix[closest][i] != 0) {
                    if (!nodes.contains(i)) {
                        if (d[closest] + matrix[closest][i] < d[i]) {
                            d[i] = matrix[closest][i] + d[closest];
                        }
                    }
                }
            }

//            count++;
//            System.out.println("\nEnd of round " + count);
//            System.out.println("Closest is " + closest);
//            System.out.println(Arrays.toString(d));
//            System.out.println(Arrays.toString(nodes.toArray()));
//            System.out.println();

        }
//        System.out.println(Arrays.toString(d));
        return d[b]-1;
    }

    static boolean close(int a, int b){
        return ((dist[a].x-dist[b].x)*(dist[a].x-dist[b].x)+(dist[a].y-dist[b].y)*(dist[a].y-dist[b].y))<1000*1000;
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
    static class Node{
        int x, y;
        public Node(int xx, int yy){
            x = xx;
            y = yy;

        }
    }
}

