import java.io.*;
import java.util.*;

public class Main {
    static int toma = 0;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n, m;
    static int[][] box;
    static void bfs() {
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && box[nx][ny] == 0) {
                    toma--;
                    box[nx][ny] = box[x][y] + 1;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        box = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                int tk = Integer.parseInt(st.nextToken());
                if(tk == 0) toma++;
                if(tk == 1) q.offer(new int[] {i, j});
                box[i][j] = tk;
            }
        }
        if(toma == 0) {
            System.out.println(0);
            return;
        }
        bfs();
        if(toma > 0) {
            System.out.println(-1);
        } else {
            int max = -2;
            for(int[] a : box) {
                for(int b : a) {
                    if(max < b) max = b;
                }
            }
            System.out.println(max - 1);
        }
    }
}