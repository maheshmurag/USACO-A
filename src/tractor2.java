/*
TASK: template
LANG: JAVA
ID: maheshm2
 */
import java.io.*;

public class tractor2 {
    static StreamTokenizer input;
    static int[][] grid;
    static boolean[][] visited;
    static int n, d;
    public static void main(String[] args) throws IOException {
        String prob = "template";
        //        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        n = nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
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

        {
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visited[i][j]){
                        dfs(i,j);
                    }
                }
            }
        }

        output.println();
        output.close();

    }

    static void dfs(int x, int y){
        if(x<0||x>=n||y<0||y>=n||visited[x][y])
            return;

        visited[x][y] = true;

        if(Math.abs(grid[x+1][y]-grid[x][y]) <= d)
            dfs(x+1,y);
        if(Math.abs(grid[x-1][y]-grid[x][y]) <= d)
            dfs(x-1,y);
        if(Math.abs(grid[x][y+1]-grid[x][y]) <= d)
            dfs(x,y+1);
        if(Math.abs(grid[x][y-1]-grid[x][y]) <= d)
            dfs(x,y-1);

    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

