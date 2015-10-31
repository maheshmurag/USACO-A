/*
TASK: pwrfail
LANG: JAVA
ID: maheshm2
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;

public class pwrfail {
    static StreamTokenizer input;
    public static void main(String[] args) throws IOException {
        String prob = "pwrfail";
                input =new StreamTokenizer(new BufferedReader(new FileReader(prob+".in")));
//        input = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    }
    static int nextInt() throws IOException {
        input.nextToken();
        return (int) input.nval;
    }
}

