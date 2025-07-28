import java.util.*;
import java.io.*;

public class Main {
    static int[][] m;
    static boolean[][] v;
    static int[][] dist;
    static int mx;
    static int my;
    static void bfs(int x, int y) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        dist[x][y] = 1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {x, y});
        v[x][y] = true;
        while(!q.isEmpty()) {
            int[] a = q.poll();
            if(a[0] == mx - 1 && a[1] == my - 1) {
                return;
            }
            for(int i = 0 ; i < 4 ; i++) {
                int nx = a[0] + dx[i];
                int ny = a[1] + dy[i];
                if(nx >= 0 && nx < mx && ny >= 0 && ny < my && !v[nx][ny] && m[nx][ny] == 1) {
                    q.offer(new int[] {nx, ny});
                    v[nx][ny] = true;
                    dist[nx][ny] = dist[a[0]][a[1]] + 1;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        mx = Integer.parseInt(st.nextToken());
        my = Integer.parseInt(st.nextToken());
        m = new int[mx][my];
        v = new boolean[mx][my];
        dist = new int[mx][my];

        for(int i = 0 ; i < mx ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < my ; j++) {
                m[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(dist[mx - 1][my - 1]);
        /*for(int[] a : dist) {
            System.out.println(Arrays.toString(a));
        }*/

    }
}