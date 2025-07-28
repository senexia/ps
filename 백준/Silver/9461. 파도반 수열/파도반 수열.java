import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int max = -1;
        int[] temp = new int[tc];
        long[] dp = new long[101];
        for(int i = 0 ; i < tc ; i++) {
            temp[i] = Integer.parseInt(br.readLine());
            max = max < temp[i] ? temp[i] : max;
        }
        dp[1]=1;
        dp[2]=1;
        dp[3]=1;
        dp[4]=2;
        dp[5]=2;
        dp[6]=3;
        dp[7]=4;
        dp[8]=5;
        dp[9]=7;
        for(int i = 9 ; i < max + 1; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        StringBuilder sb = new StringBuilder();
        for(int i : temp) {
            sb.append(dp[i]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}