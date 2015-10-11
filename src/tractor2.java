/*
TASK: tractor2
LANG: JAVA
ID: maheshm2
 */
import java.io.*;
import java.lang.Integer;
import java.util.Arrays;

public class tractor2 {
    static StreamTokenizer input;
    static int[][] grid;
    static int[][] visited;
    static int n, d, c;
    public static void main(String[] args) throws IOException {
        String prob = "tractor2";
//        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        n = nextInt();
        grid = new int[n][n];
        visited = new int[n][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = nextInt();
                if(grid[i][j] > max){
                    max = grid[i][j];
                }
            }
        }

        d = max;
        int prevd = Integer.MAX_VALUE, min = d;
        outerouterloop:
        while(d!=prevd)
        {
            visited = new int[n][n];
            c = 0;
            outerloop:
            for(int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if(visited[i][j]==0) {
                        c++;
                        dfs(i, j);
                        int count = 0;
                        for (int k = 0; k < n; k++) {
                            for (int l = 0; l < n; l++) {
                                if (visited[k][l] != 0) count++;
                                if (count >= Math.ceil(1.0 * n * n / 2.0)) {
                                    if(d > prevd){
//                                        System.out.println(d+":"+prevd);
                                      break outerouterloop;
                                    }
                                    prevd = d;
                                    min = d;
                                    d /= 2;
//                                    System.out.println("d is 1now " + d);
                                    break outerloop;
                                }
                                if(k==n-1&&l==n-1&&count < Math.ceil(1.0 * n * n / 2.0)){
                                    prevd = d;
                                    d = (int)(d + Math.floor(1.0*d/2));
//                                    System.out.println("d is 2now " + d);
                                    break outerloop;
                                }
                            }
                        }
                    }
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(visited[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(d);
    }

    static void dfs(int x, int y){

        if(x<0||x>=n||y<0||y>=n||visited[x][y]!=0)
            return;
        visited[x][y] = c;

        if(x+1<grid.length&&Math.abs(grid[x+1][y]-grid[x][y]) <= d) {
//            visited[x+1][y] = true;
            dfs(x + 1, y);
        }
        if(x-1>=0&&Math.abs(grid[x-1][y]-grid[x][y]) <= d) {
//            visited[x-1][y] = true;
            dfs(x - 1, y);
        }
        if(y+1<grid[0].length&&Math.abs(grid[x][y+1]-grid[x][y]) <= d) {
//            visited[x][y+1] = true;
            dfs(x, y + 1);
        }
        if(y-1>=0&&Math.abs(grid[x][y-1]-grid[x][y]) <= d) {
//            visited[x][y-1] = true;
            dfs(x, y - 1);
        }
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

