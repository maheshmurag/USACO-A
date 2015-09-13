/*
TASK: castle
LANG: JAVA
ID: maheshm2
 */

import java.io.*;

public class castle {
    static StreamTokenizer input;
    static int[][] arr, arr2;

    public static void main(String[] args) throws java.io.IOException {
        String prob = "castle";
        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));

        int m = nextInt(), n = nextInt();
        arr = new int[n][m];
        arr2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = nextInt();
                arr2[i][j] = 0;
            }
        }
        int count = 0, biggestRoom = 0;        int[] rs = new int[n*m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr2[i][j] == 0) {
                    count++;
                    int squares = dfs(i, j, count);
                    if (squares > biggestRoom)
                        biggestRoom = squares;
                    rs[count] = squares;

                }
            }
        }

        int max = 0;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if(north(arr[i][j]) && arr2[i-1][j] != arr2[i][j]) {
                    int v = rs[arr2[i][j]] + rs[arr2[i - 1][j]];
                    if (v > max)
                        max = v;
                }
                if (east(arr[i][j]) && arr2[i][j+1] != arr2[i][j]) {
                    int v = rs[arr2[i][j]] + rs[arr2[i][j+1]];
                    if (v > max)
                        max = v;
                }
                if (south(arr[i][j]) && arr2[i+1][j] != arr2[i][j]) {
                    int v = rs[arr2[i][j]] + rs[arr2[i + 1][j]];
                    if (v > max)
                        max = v;
                }
                if (west(arr[i][j]) && arr2[i][j-1] != arr2[i][j]) {
                    int v = rs[arr2[i][j]] + rs[arr2[i][j-1]];
                    if (v > max)
                        max = v;
                }
            }
        }
        output.println(count);
        output.println(biggestRoom);
        output.println(max);
        output.close();
    }

    static int dfs(int i, int j, int c) {
        if (!(i >= 0 && i < arr2.length && j >= 0 && j < arr2[0].length) || arr2[i][j] != 0)
            return 0;
        int x = arr[i][j];
        if ((north(x) || (i > 0 && arr2[i - 1][j] > 0))
                && (east(x) || (j < arr2[0].length - 1 && arr2[i][j + 1] > 0))
                && (south(x) || (i + 1 < arr2.length - 1 && arr2[i + 1][j] > 0))
                && (west(x) || (j >= 1 && arr2[i][j - 1] > 0))) {
            arr2[i][j] = c;
            return 1;
        }
        int num = 1;
        arr2[i][j] = c;
        if (!north(x)) num += dfs(i - 1, j, c);
        if (!east(x)) num += dfs(i, j + 1, c);
        if (!south(x))num += dfs(i + 1, j, c);
        if (!west(x)) num += dfs(i, j - 1, c);
        return num;
    }

    static void print2dArr(int[][] asdf) {
        for (int i = 0; i < asdf.length; i++) {
            for (int j = 0; j < asdf[0].length; j++) {
                System.out.print(asdf[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }

    static boolean north(int x) {
        return ((x >> 1) & 1) > 0;
    }

    static boolean south(int x) {
        return ((x >> 3) & 1) > 0;
    }

    static boolean east(int x) {
        return ((x >> 2) & 1) > 0;
    }

    static boolean west(int x) {
        return ((x & 1) > 0);
    }
}

