import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int sum = 0;

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] ret = new int[m];

        for(int i = 0 ; i < m ; i++) {
            ret[i] = Integer.parseInt(st.nextToken());

        }

        int[][] dp = new int[n][sum + 1];
        dp[0][0] = 1;
        dp[0][arr[0]] = 1;
        for(int i = 1 ; i < n ; i++) {
            for(int j = 0 ; j < sum + 1 ; j++) {
                if(dp[i - 1][j] == 1) {
                    int temp = Math.abs(j - arr[i]);
                    dp[i][j] = 1;
                    dp[i][temp] = 1;
                    dp[i][j + arr[i]] = 1;
                }
            }
        }
//        for(int[] a : dp) System.out.println(Arrays.toString(a));

        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0 ; i < sum + 1 ; i++) {
            if(dp[n - 1][i] == 1) hs.add(i);
        }

        for(int i = 0 ; i < m ; i++) {
            if(hs.contains(ret[i])) sb.append("Y ");
            else sb.append("N ");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }


}