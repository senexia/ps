import java.io.*;
import java.util.*;
  
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
  
        for(int tt = 0 ; tt < tc ; tt++) {
            sb.append("#").append(tt+1).append(" ");
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[][] dp = new int[n + 1][l + 1];
            int[] sc = new int[n + 1];
            int[] c = new int[n + 1];
  
            for(int ttt = 1 ; ttt <= n ; ttt++) {
                st = new StringTokenizer(br.readLine(), " ");
                sc[ttt] = Integer.parseInt(st.nextToken());
                c[ttt] = Integer.parseInt(st.nextToken());
            }
  
            for(int i = 1 ; i <= n ; i++) {
                for(int j = 0 ; j <= l ; j++) {
                    if(j < c[i]) dp[i][j] = dp[i-1][j];
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-c[i]] + sc[i]);
                    }
                }
            }
            sb.append(dp[n][l]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}