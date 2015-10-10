/*
TASK: scales
LANG: JAVA
ID: maheshm2
 */
import java.io.*;
import java.util.Arrays;

public class scales {
    static StreamTokenizer input;
    public static void main(String[] args) throws java.io.IOException {
        String prob = "scales";
        input =new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        int n = nextInt();
        int c = nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++)
            w[i]=nextInt();
        long val = 0;
        Arrays.sort(w);
        for (int i = n-1; i >= 1; i--) {
            if (w[i]+w[i-1] < c){
                val += w[i] + w[i-1];
                i--;
            }
//            else if (w[i] > c){
//                i--;
//            }
//        if (w[i]+w[i-1]>c>w[i]), ??
        }
        System.out.println(val);

    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

