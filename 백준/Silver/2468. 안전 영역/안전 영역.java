
import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int n;
    static int res = 1; // 아무것도 안잠김 = 영역 1개
    static void bfs(int x, int y, int h) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int a = temp[0];
            int b = temp[1];
            for(int i = 0 ; i < 4 ; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny] && arr[nx][ny] > h) {
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        v = new boolean[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                int tok = Integer.parseInt(st.nextToken());
                if(max < tok) max = tok;
                if(min > tok) min = tok;
                arr[i][j] = tok;
            }
        }

        int comp;
        for(int k = min ; k < max ; k++) {
            comp = 0;
            for(boolean[] vis : v) Arrays.fill(vis, false);
            for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    if(arr[i][j] > k && !v[i][j]) {
                        comp++;
                        v[i][j] = true;
                        bfs(i, j, k);
                    }
                }
            }
            if(res < comp) res = comp;
        }
        System.out.println(res);

    }
}