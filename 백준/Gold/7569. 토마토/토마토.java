import java.io.*;
import java.util.*;

public class Main {
    static int toma = 0;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static int xl, yl, zl;
    static int[][][] box;
    static void bfs() {
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int z = temp[2];
            for(int i = 0 ; i < 6 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                if(nx >= 0 && nx < xl && ny >= 0 && ny < yl &&  nz >= 0 && nz < zl && box[nx][ny][nz] == 0) {
                    toma--;
                    box[nx][ny][nz] = box[x][y][z] + 1;
                    q.offer(new int[] {nx, ny, nz});
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        yl = Integer.parseInt(st.nextToken());
        xl = Integer.parseInt(st.nextToken());
        zl = Integer.parseInt(st.nextToken());

        box = new int[xl][yl][zl];
        for(int k = 0 ; k < zl ; k++) {
            for(int i = 0 ; i < xl ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < yl ; j++) {
                    int tok = Integer.parseInt(st.nextToken());
                    if(tok == 0) toma++;
                    if(tok == 1) q.offer(new int[] {i, j, k});
                    box[i][j][k] = tok;
                }
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
            for(int[][] a : box) {
                for(int b[] : a) {
                    for(int c : b) {
                        if(max < c) max = c;
                    }
                }
            }
            System.out.println(max - 1);
        }
    }
}