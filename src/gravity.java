/*
TASK: gravity
LANG: JAVA
ID: maheshm2
 */

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class gravity {
    static StreamTokenizer input;
    static int n, m;
    static int start = -1, end = -1;
    static int grid[][];
    static Node source, goal;
    static LinkedList<Node> graph;

    public static void main(String[] args) throws IOException {
        String prob = "gravity";
        input = new StreamTokenizer(new BufferedReader(new FileReader(prob + ".in")));
        PrintWriter output = new PrintWriter(new FileWriter(prob + ".out"));
        graph = new LinkedList<Node>();
        n = nextInt();
        m = nextInt();
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String row = nextStr();
            for (int j = 0; j < m; j++) {
                if (row.charAt(j) == '#')
                    grid[i][j] = 0;//wall
                else if (row.charAt(j) == '.')
                    grid[i][j] = 1;//empty
                else if (row.charAt(j) == 'C') {
                    grid[i][j] = 2;
                } else if (row.charAt(j) == 'D') {
                    grid[i][j] = 3;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    Node n = new Node(i, j, count);
                    graph.add(n);
                    if (grid[i][j] == 2) {
                        start = count;
                        source = n;
                    }
                    if (grid[i][j] == 3) {
                        end = count;
                        goal = n;
                    }
                    count++;
                }
            }
        }
        System.out.println(solve());
        output.println();
        output.close();

    }

    static int solve() {
        PriorityQueue<Node> queue = new PriorityQueue<Node>();
        queue.add(graph.get(start));
        boolean visited[] = new boolean[graph.size()];
        int previous[] = new int[graph.size()];
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            if (top.x == goal.x && top.y == goal.y) {
                int x = end;
                Node xx = goal;
                int c = 0;
                while (xx != source) {
                    x = previous[x];
                    xx = graph.get(x);
                    c++;
                }
                return c;
            }
            for (Node node : top.adj) {
                if (!visited[a]) {
                    queue.add(graph.get(a));
                    visited[a] = true;
                int a = node.index;
                    previous[a] = top.index;
                }
            }
        }
        return -1;
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }

    static String nextStr() throws IOException {
        input.nextToken();
        return input.sval;
    }

    static class Node implements Comparator<Node> {
        LinkedList<Node> adj = new LinkedList<Node>();
        int x, y, cost, index;

        public Node(int a1, int a2, int ind) {
            this.x = a1;
            this.y = a2;
            this.cost = 0;
            this.index = ind;
        }

        public int compare(Node one, Node two) {
            return one.cost - two.cost;
        }
    }
}
