/*
TASK: ttime
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.util.Arrays;

public class ttime {
    static StreamTokenizer input;
    static int n, m, q, id;
    static boolean[][] matrix;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        String prob = "ttime";
        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        n = nextInt();
        m = nextInt();
        q = nextInt();
        matrix = new boolean[n + 1][n + 1];
        visited = new int[n + 1];
        Arrays.fill(visited, 0);
        for (int i = 0; i < m; i++) {
            int one = nextInt(), two = nextInt();
            matrix[one][two] = true;
            matrix[two][one] = true;
        }
//        System.out.println(nextInt());
        id = 1;
        for (int i = 1; i <= n; i++) {
            if(visited[i]==0){//not visited
                visited[i] = id;
                dfs(i);
                id++;
            }
        }

        for (int i = 0; i < q; i++) {
            int a = nextInt(); int b = nextInt();
            System.out.println(visited[a]==visited[b]?"Y":"N");
        }

        output.close();
    }

    static void dfs(int index){
        if(index<0 || index>=n+1)
            return;
        visited[index]=id;
        for (int i = 1; i <= n; i++) {
            if(matrix[i][index] && visited[i] == 0){
                dfs(i);
            }
        }
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

