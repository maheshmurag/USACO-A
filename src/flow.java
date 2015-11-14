/*
TASK: flow
LANG: JAVA
ID: maheshm2
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class flow {
    static StreamTokenizer input;
    static int[][] matrix;
//    static char chars;
    static int n;
    public static void main(String[] args) throws IOException {
                input =new StreamTokenizer(new BufferedReader(new FileReader("flow.in")));
//        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        n = nextInt();
        matrix = new int[53][53];
        for (int i = 0; i < n; i++) {
            int a = c(nextChar()); int b = c(nextChar()); int c = nextInt();
            matrix[a][b]+= c;
        }
        System.out.println(path(c('A')));
    }

    public static int c(char i){
        if(i >= 97)
            return i-70;
        return i-64;
    }
    public static char c2(int i){
        if(i >= 27)
            return (char)(i+70);
        return (char)(i+64);
    }

    public static int path(int j){
        int sum = 0;
        //this is dfs and won't work when there are multiple connections between 2 nodes


        for(int i = 1; i < matrix[j].length;i++){
            if(matrix[j][i] != 0) {
                int x = path(i);
                sum += Math.min(matrix[j][i], x!=0?x:Integer.MAX_VALUE);
                System.out.println(c2(j) +" to " + c2(i) +" is " + matrix[j][i] +", path("+c2(i)+") = " + x+", adding " + Math.min(matrix[j][i], x!=0?x:Integer.MAX_VALUE));
            }
        }
        System.out.println("path("+c2(j)+") is " + sum);
        return sum;
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
    static char nextChar() throws IOException {
        input.nextToken();
        return input.sval.charAt(0);
    }
//    static class Node{
//        ArrayList<Character> outward = new ArrayList<Character>();
//        char name;
//        int dist;
//        public Node(char a, int b){
//            name = a;
//            dist = b;
//        }
//    }
}

