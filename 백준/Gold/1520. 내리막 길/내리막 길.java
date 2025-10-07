import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr, dp;

    static int dfs(int x, int y) {
        if(x == n - 1 && y == m - 1) {
            return 1;
        }
        if(dp[x][y] != -1) {
            return dp[x][y];
        }

        dp[x][y] = 0;
        int cnt = 0;

        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[x][y] > arr[nx][ny]) {
                cnt += dfs(nx, ny);
            }
        }
        return dp[x][y] = cnt;
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        /*
        dfs로 하니까 시간초과남

        중복 경우를 줄여야 한다 -> dp생각
        예시로 보여준 2, 3번째 그림만 봐도 2행 4열의 '20'을 두번 지나므로
        사실 최초로 20에 도달한 이후, 나중에 20에 도달한 경우는 끝까지 돌 필요가 없음

        따라서 dp[x][y] : (x, y)에서 도착지까지 가는 경우의 수 로 상태 설정

        방문배열도 dp배열로 대체
        -1 : 미방문
        0 : 방문할때 0으로 갱신
        양수 : 경로 수

         */
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dp = new int[n][m];

        if(n == 1 && m == 1) {
            System.out.println(1);
            return;
        }

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }


        dp[0][0] = dfs(0, 0);
        System.out.println(dp[0][0]);


    }

}