/*
TASK: djikstra
LANG: JAVA
ID: maheshm2
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class djikstra {
    static StreamTokenizer input;
    public static void main(String[] args) throws IOException {
        String prob = "djikstra";
                input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
//        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        int v = nextInt();int e= nextInt();int s = nextInt();
        int[][] matrix = new int[v+1][v+1];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = 0;
        for (int i = 0; i < e; i++) {
            int a = nextInt();int b = nextInt();int c = nextInt();
            matrix[a][b] = c;
            matrix[b][a] = c;
        }
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        int[] d = new int[v+ 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[s]= 0;
        int counter=0;
        while(nodes.size()!=v){
            counter++;
            int closest = -1;
            for (int i = 1; i <= v; i++) {
                if(d[i]<(closest==-1?Integer.MAX_VALUE:d[closest]) && !nodes.contains(i)){
                    if(counter!=1 && i!=s) closest = i;
                    else closest = s;
                }
            }
            if(closest<=0)
                break;
            nodes.add(closest);
            for (int i = 1; i <= v ; i++)
                if(matrix[closest][i] != 0 && !nodes.contains(i))
                    if(d[closest] + matrix[i][closest] < d[i])
                        d[i] = matrix[i][closest] + d[closest];
        }
        for (int i = 1; i <= v; i++)
            System.out.println(d[i]==Integer.MAX_VALUE?-1:d[i]);
    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

