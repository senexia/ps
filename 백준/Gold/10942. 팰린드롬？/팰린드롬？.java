import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        N이 최대면 가장 길이가 긴 쿼리의 비교 횟수는 1000회
        매 쿼리마다 판별한다고 하면 10억회로 시간초과

        전처리를 해두자

        모든 부분 회문을 N^2안에 찾아야 함
        시간복잡도 고려하면 dp밖에 없는거같은데
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][n + 1];
        //정의 : i번째부터 j번째까지 문자열이 회문인지 여부

        for(int i = 1 ; i <= n ; i++) {
            for(int j = i ; j <= n ; j++) {
                if(i == j) dp[i][j] = true;
                if(arr[j - 1] == arr[j]) dp[j - 1][j] = true;
            }
        }
        
        //테케 답 안 나온 이유
        //이 논리 자체는 맞는데, 부분문제의 포함관계를 고려했을 때 i는 내림차순으로 전개되어야 함
        for(int i = n ; i >= 1 ; i--) {
            for(int j = i ; j <= n ; j++) {
                if(i + 1 <= j - 1 && arr[i] == arr[j] && dp[i + 1][j - 1]) dp[i][j] = true;
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] ? "1\n" : "0\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}
