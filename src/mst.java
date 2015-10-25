/*
TASK: mst
LANG: JAVA
ID: maheshm2
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class mst {
    static StreamTokenizer input;
    public static void main(String[] args) throws IOException {
        String prob = "mst";
                input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
//        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        int v = nextInt(); int e = nextInt();
        int[][] arr = new int[v+1][v+1];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = Integer.MAX_VALUE;
        for (int i = 0; i < e; i++) {
            int a = nextInt(); int b = nextInt(); int c = nextInt();
            arr[a][b] = c;
            arr[b][a] = c;
        }
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        nodes.add(1);
        nodes.add(2);
        int costOut = arr[1][2];
        while(nodes.size()<v){
            int neighborMinCost = Integer.MAX_VALUE;
            int nodeToAdd = 0;
            for (int i = 0; i < nodes.size(); i++)
                for (int j = 1; j <= v; j++)
                    if (j != nodes.get(i) && !nodes.contains(j))
                        if (arr[nodes.get(i)][j] < neighborMinCost) {
                            neighborMinCost = arr[nodes.get(i)][j];
                            nodeToAdd = j;
                        }
            costOut += neighborMinCost;
            nodes.add(nodeToAdd);
        }
        System.out.println(costOut);
    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

