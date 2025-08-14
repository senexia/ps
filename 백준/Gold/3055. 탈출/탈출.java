import java.io.*;
import java.util.*;


public class Main {
    static int r, c;
    static int ax = 0;
    static int ay = 0;
    static int dist = -1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] arr;
    static int[][] water;
    static boolean[][] v;
    static boolean[][] wv;
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static void bfs() {
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int d = temp[2];
            if(x == ax && y == ay) {
                dist = d;
                return;
            }
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < r && ny >= 0 && ny < c
                        && !v[nx][ny]
                        && arr[nx][ny] != '*'
                        && arr[nx][ny] != 'X'
                        && (water[nx][ny] == 0 || d + 1 < water[nx][ny])) {
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny, d + 1});
                }
            }
        }
    }
    static void waterbfs() {
        while(!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < r && ny >= 0 && ny < c && !wv[nx][ny] && arr[nx][ny] == '.') {
                    water[nx][ny] = water[x][y] + 1;
                    wv[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        water = new int[r][c];
        v = new boolean[r][c];
        wv = new boolean[r][c];
        int stx = 0;
        int sty = 0;

        for(int i = 0 ; i < r ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < c ; j++) {
                char ch = s.charAt(j);
                if(ch == '*') {
                    q.offer(new int[] {i, j});
                    water[i][j] = 0;
                    wv[i][j] = true;
                }
                if(ch == 'D') {
                    ax = i;
                    ay = j;
                    water[i][j] = Integer.MAX_VALUE;
                }
                if(ch == 'S') {
                    stx = i;
                    sty = j;
                }
                arr[i][j] = ch;
            }
        }
        waterbfs();
//        for(int[] w : water) System.out.println(Arrays.toString(w));
        q.offer(new int[] {stx, sty, 0});
        bfs();
        System.out.println(dist == -1 ? "KAKTUS" : dist);
    }
}