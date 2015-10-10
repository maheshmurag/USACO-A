/*
TASK: baler
LANG: JAVA
ID: maheshm2
 */
import java.io.*;

public class baler {
    static StreamTokenizer input;
    static Roller rollers[];
    static int n,xt,yt;
    static double totalSum = 0;

    public static void main(String[] args) throws java.io.IOException {
        String prob = "baler";
        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));

        n = nextInt();xt = nextInt();yt = nextInt();
        int start=-1;
        rollers = new Roller[n];
        for (int i = 0; i < n; i++) {
            rollers[i] = new Roller(nextInt(), nextInt(), nextInt());
            if(rollers[i].x == 0 && rollers[i].y == 0)
                start = i;
        }

        rec(start, 10000);
        System.out.println(totalSum);
        output.println();
        output.close();

    }

    static void rec(int ind, double prevSpeed){
        if(ind>=rollers.length || ind<0 || (rollers[ind].x == xt && rollers[ind].y == yt))
            return;
        rollers[ind].visited = true;

        for (int i = 0; i < rollers.length; i++) {
            if(i!=ind && !rollers[i].visited){
                if(eq(rollers[ind], rollers[i]))
                {

                    double speed = prevSpeed * (1.0 * rollers[ind].r/rollers[i].r);
                    System.out.println(speed);
                    totalSum += speed;
                    rec(i, speed);
                }
            }
        }

    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
    static class Roller{
        int x, y, r;
        boolean visited;
        public Roller(int a, int b, int c)
        {
            x = a;
            y = b;
            r = c;
            visited = false;
        }
    }
    public static boolean eq(Roller one,Roller two){
        return (two.x-one.x)*(two.x-one.x) + (two.y-one.y)*(two.y-one.y) == (one.r+two.r) * (one.r+two.r);
    }
}

