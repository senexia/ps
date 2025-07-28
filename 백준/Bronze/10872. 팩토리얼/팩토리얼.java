import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] dp = new long[15];
        dp[0] = 1;
        for(int i = 1 ; i <= 14 ; i++) {
            dp[i] = i * dp[i-1];
        }
        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
        bw.flush();
        bw.close();
    }
}