import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j <= i ; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = -1;
        for(int i = 1 ; i < n ; i++) {
            for(int j = 0 ; j <= i ; j++) {
                if(j == 0) dp[i][j] += dp[i-1][j];
                else if(j == i) dp[i][j] += dp[i-1][j-1];
                else {
                    dp[i][j] = dp[i-1][j-1] > dp[i-1][j] ? dp[i-1][j-1] + dp[i][j] : dp[i-1][j] + dp[i][j];
                }
            }
        }
        for(int j = 0 ; j < n ; j++) {
            if(max < dp[n-1][j]) max = dp[n-1][j];
        }
        System.out.println(max);
//        for(int[] a : dp) System.out.println(Arrays.toString(a));
    }
}