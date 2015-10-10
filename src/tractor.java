import java.io.*;

public class tractor {
    static StreamTokenizer input;
    public static void main(String[] args) throws IOException {
        String prob = "tractor";
        input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
        PrintWriter output=new PrintWriter(new FileWriter(prob+".out"));



        output.println();
        output.close();

    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

