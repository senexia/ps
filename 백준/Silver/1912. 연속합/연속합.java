import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n == 1) {
            System.out.println(arr[0]);
            return;
        }
        dp[0] = arr[0];
        int max = dp[0];
        for(int i = 1 ; i < n ; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            if(max < dp[i]) max = dp[i];
        }
        System.out.println(max);
    }
}