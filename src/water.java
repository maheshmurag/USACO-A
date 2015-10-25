/*
TASK: water
LANG: JAVA
ID: maheshm2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class water {
    static StreamTokenizer input;
    public static void main(String[] args) throws IOException {
        String prob = "water";
//                input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        int n = nextInt();
        int[][] arr = new int[n+2][n+2];
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                arr[i][j] = Integer.MAX_VALUE;
        int mina=0, minb=0, minc=Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int asdf = nextInt();
            arr[n+1][i] = asdf;
            arr[i][n+1] = asdf;
            if(asdf<minc){
                minc=asdf;
                mina=n+1;
                minb=i;
            }
        }
        arr[n+1][n+1] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int asdf =nextInt();
                arr[i][j] =asdf;
                arr[j][i] =asdf;
                if(i==j)
                    arr[i][j]=Integer.MAX_VALUE;
                else if(asdf<minc){
                    minc=asdf;
                    mina=i;
                    minb=j;
                }
            }
        }
        ArrayList<Integer> nodes = new ArrayList<Integer>();
        nodes.add(mina);
        nodes.add(minb);
        int costOut = minc;
        while(nodes.size()<=n){
            int neighborMinCost = Integer.MAX_VALUE;
            int nodeToAdd = 0;
            for (int i = 0; i < nodes.size(); i++)
                for (int j = 1; j <= n+1; j++)
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

