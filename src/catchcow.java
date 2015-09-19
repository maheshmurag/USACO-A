/*
TASK: catchcow
LANG: JAVA
ID: maheshm2
 */
import java.io.*;

public class catchcow {
    static StreamTokenizer input;
    static int n,k, min = Integer.MAX_VALUE;
//    static int[] dp = new int[100001];
    public static void main(String[] args) throws java.io.IOException {
        String prob = "catchcow";
        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));

        n = nextInt();
        k=nextInt();
//        Arrays.fill(dp,-1);

        int ans = Math.min(rec(n+1,n,1),rec(n-1,n,1));
        ans = Math.min(ans, rec(n*2,n,1));

        output.println(min);
        output.close();

    }

    static int rec(int pt, int prev, int count){
        if(pt>100000 || pt<0) return 0;
//        System.out.println(pt+":"+prev+":"+count);
        if(pt == k){
            if (count<min) min = count;
            return count;
        }
//        if(dp[pt]!=-1) return dp[pt];
        int out = Math.min((prev==pt+1||pt > k)?Integer.MAX_VALUE:rec(pt+1,pt, count+1),
                (prev==pt-1 || pt < k)?Integer.MAX_VALUE:rec(pt-1,pt, count+1));
        out = Math.min(out, (pt > k || pt == 0)?Integer.MAX_VALUE:rec(pt*2,pt, count+1));
//        dp[pt] = out;
        return out;
    }

    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

