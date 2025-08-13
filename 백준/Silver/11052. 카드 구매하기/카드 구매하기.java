import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] cd = new int[n];
        int[] dp = new int[n + 1];


        for(int i = 0 ; i < n ; i++) {
            cd[i] = Integer.parseInt(st.nextToken());
        }
        /*
        n개를 사는 경우는
        n-1개랑 1개를 사는 경우
        n-2개랑 2개를 사는 경우
        ...
        n-k개랑 k개를 사는 경우
        ...

        k개를 사는 경우도 또 쪼개지지 않나 -> 바텀업 하면 문제없다.
        */
        if(n == 1) {
            System.out.println(cd[0]);
            return;
        }
        dp[0] = 0;
        dp[1] = cd[1];
        for(int i = 1 ; i <= n ; i++) {
            int max = -1;
            for(int j = 1 ; j <= i ; j++) {
                if(j != i) {
                    if(max < dp[i - j] + dp[j]) max = dp[i - j] + dp[j];
                } else {
                    if(max < dp[i - j] + cd[i - 1]) max = dp[i - j] + cd[i - 1];
                    //i랑 j가 같으면 0개 구매 + n개 구매가 되는데 dp[n]은 없으니 이때만 따로 빼서
                    //카드 n개 구매가격인 cd[n - 1]로
                }
            }
            dp[i] = max;
        }
        System.out.println(dp[n]);
    }
}