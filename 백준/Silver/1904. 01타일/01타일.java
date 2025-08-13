import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        if(n <= 2) {
            System.out.println(n);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= n ; i++) {
            dp[i] = (dp[i - 1] % 15746 + dp[i - 2] % 15746) % 15746;
        }
        System.out.println(dp[n]);


        /*
        길이1
1

길이2
11
00

길이3
111
100
001

길이4
1111
1001
0011
1100
0000



길이3
111 = 11 + 1 (2번째)
001 = 00 + 1 (2번째)
100 = 1 + 00 (1번째)


길이4
1111 = 111 + 1 (3번째)
1001 = 100 + 1 (3번째)
0011 = 001 + 1 (3번째)
1100 = 11 + 00 (2번째)
0000 = 00 + 00 (2번째)

(n번째 경우) = (n-1번째 경우) + (n-2번째 경우)
        */
    }
}