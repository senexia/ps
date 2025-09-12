import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i < n + 1 ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0 ; i < n + 1 ; i++) {
            if(max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}