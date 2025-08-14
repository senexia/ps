import java.io.*;
import java.util.*;


public class Main {
    static int r, c;
    static int dist = -1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] fire;
    static char[][] arr;
    static boolean[][] v;
    static ArrayDeque<int[]> q = new ArrayDeque<>();

    static void bfs() {
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int d = temp[2];
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= r || ny < 0 || ny >= c) {
                    //탈출
                    dist = d + 1;
                    return;
                } else {
                    //내부에 있고, 갈 수 있는 지형이고, 불이 안 왔거나, 불보다 빠르게 방문했거나
                    if(!v[nx][ny] && arr[nx][ny] == '.' && (fire[nx][ny] == 0 || d + 1 < fire[nx][ny])) {
                        v[nx][ny] = true;
                        q.offer(new int[] {nx, ny, d + 1});
                    }
                }
            }
        }
    }
    static void fbfs() {
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < r && ny >= 0 && ny < c && !v[nx][ny] && arr[nx][ny] == '.') {
                    v[nx][ny] = true;
                    fire[nx][ny] = fire[x][y] + 1;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        fire = new int[r][c];
        arr = new char[r][c];
        v = new boolean[r][c];
        int stx = 0;
        int sty = 0;

        for(int i = 0 ; i < r ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < c ; j++) {
                char ch = s.charAt(j);
                if(ch == 'F') {
                    q.offer(new int[]{i, j});
                    fire[i][j] = 0;
                }
                if(ch == 'J') {
                    stx = i;
                    sty = j;
                }
                arr[i][j] = ch;
            }
        }

        fbfs();
        q.offer(new int[] {stx, sty, 0});
        for(boolean[] b : v) Arrays.fill(b, false);
//        for(int[] f : fire) System.out.println(Arrays.toString(f));
        bfs();
        System.out.println(dist == -1 ? "IMPOSSIBLE" : dist);
    }
}