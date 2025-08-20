import java.io.*;
import java.util.*;


public class Main {
    static int n, m;
    static int stx = -1;
    static int sty = -1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static char[][] arr;
    static boolean[][] v;
    static int[][] dist;

    static ArrayDeque<int[]> q = new ArrayDeque<>();

    static void bfs1() {
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m
                        && (arr[nx][ny] == '.' || arr[nx][ny] == '@')
                        && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }

    static int bfs2() {
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int d = temp[2];

            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    return d + 1;
                }
                if(!v[nx][ny]
                && arr[nx][ny] == '.'
                && (dist[nx][ny] == 0 || dist[nx][ny] > d + 1)) {
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny, d + 1});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= tc ; t++) {
            int ret = 0;
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            arr = new char[n][m];
            v = new boolean[n][m];
            dist = new int[n][m];

            for(int i = 0 ; i < n ; i++) {
                String s = br.readLine();
                for(int j = 0 ; j < m ; j++) {
                    char c = s.charAt(j);
                    if(c == '*') {
                        dist[i][j] = 1;
                        q.offer(new int[] {i, j});
                    } else if(c == '@') {
                        stx = i;
                        sty = j;
                        v[i][j] = true;
                    }
                    arr[i][j] = c;
                }
            }

            bfs1();
            //for(int[] d : dist) System.out.println(Arrays.toString(d));
            q.offer(new int[] {stx, sty, 1});
            ret = bfs2();
            q.clear();
            sb.append(ret == 0 ? "IMPOSSIBLE" : ret - 1).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}