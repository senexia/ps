import java.io.*;
import java.util.*;

public class Main {
    static int n, m, d, cnt;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
//    static int[][] arr;
    static boolean[][] v;

    static void dfs(int x, int y, int dep) {
        if(x == 0 && y == m - 1 && dep == d) {
            cnt++;
            return;
        }

        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < m && !v[nx][ny] && dep + 1 <= d) {
                v[nx][ny] = true;
                dfs(nx, ny, dep + 1);
                v[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        cnt = 0;

        v = new boolean[n][m];

        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < m ; j++) {
                if(s.charAt(j) == 'T') v[i][j] = true;
            }
        }
        v[n - 1][0] = true;
        dfs(n - 1, 0, 1);
        System.out.println(cnt);
    }
}