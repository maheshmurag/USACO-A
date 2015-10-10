/*
TASK: mud
LANG: JAVA
ID: maheshm2
 */
import java.io.*;

public class mud {
    static StreamTokenizer input;
    static int cpub = 0, xx=0,yy=0;
    static boolean[][] M;
    public static void main(String[] args) throws IOException {
        String prob = "mud";
        input =new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));

        M = new boolean[1001][1001];
        
        xx=nextInt()+500;yy=nextInt()+500;int num_M = nextInt();
        for (int i = 0; i < num_M; i++){
//            int one = nextInt()+500;int two = nextInt()+500;
            M[nextInt()+500][nextInt()+500] = true;
        }
        solve(500, 500, 0, 0);
        System.out.println(cpub);
//        output.close();

    }

    public static void solve(int x, int y, int count, int dir){
        if(x<0 || x > 1000 || y<0 || y > 1000){
            return;
        }
//        System.out.println((y-500)+":"+(x-500)+":"+count+":"+dir);
        if(y == xx && x == yy) {
//            System.out.println("success");
            cpub = count;
            return;
        }
        if(dir != 1 && x+1<=1000 && M[x+1][y] == false)solve(x+1, y, count+1,2);
        if(dir != 2 && x-1>=0 && M[x-1][y] == false)solve(x-1, y, count+1,1);
        if(dir != 3 && y+1<=1000 && M[x][y+1] == false)solve(x, y+1, count+1,4);
        if(dir != 4 && y-1>=0&& M[x][y-1] == false)solve(x, y-1, count+1,3);
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}
