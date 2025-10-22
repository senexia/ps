import java.io.*;
import java.util.*;

public class Main {
    static int n, cnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static List<int[]> prop = new ArrayList<>();
    static List<int[]>[][] button;
    static boolean[][] v, light;

    static void propagation() {
        for(boolean[] vv : v) Arrays.fill(vv, false);
//        for(int[] a : prop) {
//            q.offer(a);
//            v[a[0]][a[1]] = true;
//        }
        q.offer(new int[] {0, 0});
    }

    static void bfs() {
        light[0][0] = true;
        v[0][0] = true;
        q.offer(new int[] {0, 0});
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            if(!button[x][y].isEmpty()) {
                int pcnt = 0;
                List<int[]> buttons = button[x][y];
                for(int[] a : buttons) {
                    int bx = a[0];
                    int by = a[1];
                    if(!light[bx][by]) {
                        light[bx][by] = true;
                        prop.add(new int[] {bx, by});
                        cnt++;
                        pcnt++;
                    }
                }
                if(pcnt > 0) {
                    propagation();
                }
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny] && light[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        button = new ArrayList[n][n];
        v = new boolean[n][n];
        light = new boolean[n][n];
        cnt = 1;
        prop.add(new int[] {0, 0});

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                button[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;

            button[sx][sy].add(new int[] {ex, ey});
        }

        bfs();

        System.out.println(cnt);
    }
}