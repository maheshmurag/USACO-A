/*
TASK: cruise
LANG: JAVA
ID: maheshm2
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class cruise {
    static StreamTokenizer input;
    public static void main(String[] args) throws IOException {
        String prob = "cruise";
//                input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt();
        int m = nextInt();
        int k = nextInt();
        int[][] arr = new int[2][n+1];
        for (int i = 1; i <= n; i++) {
            arr[0][i] = nextInt();
            arr[1][i] = nextInt();
        }
        int[] dirs = new int[m];
        for (int i = 0; i < m; i++)
            dirs[i] = nextChar()=='L'?0:1;
        int[] vis = new int[n+1];
        int curr = 1;
            Arrays.fill(vis, -1);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < m; j++) {
                curr = arr[dirs[j]][curr];
            }
            if(vis[curr] != -1)//its a loop
            {
                int dist = i - vis[curr];//number of direction_loops since last time you ended on this one
                int ans = (k-vis[curr]+1)%dist;
//                System.out.println(curr+":"+dist+":"+vis[curr]+":"+ans);
//                curr = vis[vis[curr]+ans];
                for (int o = 0; o < ans; o++) {
                    for (int j = 0; j < m; j++) {
                        curr = arr[dirs[j]][curr];
                    }
                }
                break;
            }
            if(vis[curr] == -1) vis[curr] = i;
        }
        System.out.println(curr);
//        System.out.println(Arrays.toString(vis));
    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
    static char nextChar() throws IOException {
        input.nextToken();
        return input.sval.charAt(0);
    }
}

