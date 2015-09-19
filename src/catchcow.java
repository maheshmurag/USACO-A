/*
TASK: catchcow
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.util.LinkedList;

public class catchcow {
    static StreamTokenizer input;
    static int n, k;
    public static void main(String[] args) throws java.io.IOException {
        String prob = "catchcow";
        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        n = nextInt();
        k = nextInt();
        int ans = solve();
        System.out.println(ans);
        output.close();
    }
    public static int solve(){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.push(new Integer(n));
        boolean visited[] = new boolean[100001];
        int previous[] = new int[100001];
        LinkedList<Integer> graph = new LinkedList<Integer>();
        for (int i = 0; i <= 100000; i++)
            graph.add(new Integer(i));
        int cou = 0;
        while (!queue.isEmpty()) {
            Integer top = queue.getFirst();
            queue.removeFirst();
            if (top == k) {
                int x = k;
                while (x != n) {
                    x = previous[x];
                    cou++;
                }
                break;
            }
            for (int x = 0; x < 3; x++) {
                int val = 0;
                switch(x){
                    case 0: val = -1; break;
                    case 1: val = 1; break;
                    case 2: val = top; break;
                }
                if (top+val >= 0 && top+val <= 100000 && !visited[top + val]) {
                    queue.add(graph.get(top + val));
                    visited[top + val] = true;
                    previous[top + val] = top;
                }
            }
        }
        return cou;
    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

