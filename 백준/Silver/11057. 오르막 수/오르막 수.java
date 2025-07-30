
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        /*
        0으로 끝나면 다음 10개
        1로 끝나면 다음 9개
        2로 끝나면 다음 8개
         ....
        9로 끝나면 다음 1개


        n번째 0의 개수 = n-1번째 0의 개수
        n번째 1의 개수 = n-1번째 0, 1의 개수
        n번째 2의 개수 = n-1번째 0, 1, 2의 개수
         ....
        n번째 9의 개수 = n-1번째 0, 1, 2, ..., 9의 개수

        */
        int[] dp = {1,1,1,1,1,1,1,1,1,1};
        for(int i = 1 ; i < n ; i++) {
            for(int j = 1 ; j < 10 ; j++) {
                dp[j] = (dp[j - 1] % 10007 + dp[j] % 10007) % 10007;
            }
        }
        int sum = 0;
        for(int i = 0 ; i < 10 ; i++) {
            sum = (sum % 10007 + dp[i] % 10007)%10007;
        }
        System.out.println(sum);
    }
}