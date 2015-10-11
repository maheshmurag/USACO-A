/*
TASK: alliance
LANG: JAVA
ID: maheshm2
 */
import java.io.*;

public class alliance {
    static StreamTokenizer input;
    static int matrix[][];
    static int n, m;
    public static void main(String[] args) throws IOException {
        String prob = "alliance";
        //        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        n = nextInt(); m = nextInt();
        matrix = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            int a = nextInt(); int b = nextInt();
            matrix[a][b] = 1;
            matrix[b][a] = 1;
        }
        output.println();
        output.close();

    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

