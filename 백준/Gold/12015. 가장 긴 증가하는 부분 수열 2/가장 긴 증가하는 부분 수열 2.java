import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n];
        int ptr = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            int x = Integer.parseInt(st.nextToken());

            if(i == 0 || dp[ptr - 1] < x) {
                dp[ptr++] = x;
                continue;
            }

            int key = Arrays.binarySearch(dp, 0, ptr, x);
            key = key < 0 ? -key - 1 : key;
            dp[key] = x;
        }
        System.out.println(ptr);
    }
}
