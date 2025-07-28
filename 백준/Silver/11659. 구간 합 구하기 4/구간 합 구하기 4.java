import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] l1 = br.readLine().split(" ");
        String[] l2 = br.readLine().split(" ");
        int n = Integer.parseInt(l1[0]);
        int tries = Integer.parseInt(l1[1]);

        int[] parsum = new int[n + 1];
        parsum[0] = 0;
        for(int i = 1 ; i < n + 1 ; i++) {
            parsum[i] = parsum[i-1] + Integer.parseInt(l2[i - 1]);
        }
        for(int i = 0 ; i < tries ; i++) {
            String[] se = br.readLine().split(" ");

            int s = Integer.parseInt(se[0]);
            int e = Integer.parseInt(se[1]);
            bw.write(String.valueOf(parsum[e] - parsum[s-1]) + "\n");
        }



        bw.flush();
        bw.close();
    }
}