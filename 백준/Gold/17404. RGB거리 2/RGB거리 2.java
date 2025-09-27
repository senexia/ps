import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for(int s = 0 ; s < 3 ; s++) {
            for(int i = 0 ; i < 3 ; i++) {
                if(i == s) dp[0][i] = arr[0][i];
                else dp[0][i] = 100000000;
            }

            for(int i = 1 ; i < n ; i++) {
                dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
            for(int e = 0 ; e < 3 ; e++) {
                if(e != s) {
                    min = Math.min(min, dp[n - 1][e]);
                }
            }
        }
        System.out.println(min);
    }
}