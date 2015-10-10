/*
TASK: perimeter
LANG: JAVA
ID: maheshm2
 */
import java.io.*;
import java.util.HashMap;

public class perimeter {
    static StreamTokenizer input;
    static int N;
    static boolean[][] visited;
    static int count = 0;
    static int xmin,ymin,xmax,ymax;
    static HashMap<Integer, HashMap<Integer, Boolean>> map;
    public static void main(String[] args) throws java.io.IOException {
        String prob = "perimeter";
        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));
        map = new HashMap<Integer, HashMap<Integer, Boolean>>();
        N = nextInt();
        xmin=Integer.MAX_VALUE;xmax=Integer.MIN_VALUE;ymin=Integer.MAX_VALUE;ymax=Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int x = nextInt(), y = nextInt();
            if(x<xmin)xmin=x;
            if(x>xmax)xmax=x;
            if(y>ymax)ymax=y;
            if(y<ymin)ymin=y;
            HashMap m = new HashMap<Integer, Boolean>();
            m.put(y, true);
            map.put(x, m);
        }

        visited = new boolean[xmax+1][ymax+1];
        rec(xmin, ymin-1);

        output.println();
        output.close();

    }
    static void rec(int x, int y){

        if(x == xmin && y == ymin){
            return;
        }
        if(!visited[x][y+1]){
            count++;
            visited[x][y+1]=true;
            rec(x+1, y);
        }

    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

