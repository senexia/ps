import java.io.*;
import java.util.*;


public class Main {
    static int[][] gr;
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    public static void dfs(int x, int y, int h, int w) {
        gr[x][y] = 0;
        for(int i = 0 ; i < 8 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < h && ny >= 0 && ny < w && gr[nx][ny] == 1) {
                dfs(nx, ny, h, w);
            }
        }
    }

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = 0;
        StringTokenizer st;
        while(true) {
            String line = br.readLine();
            if(line.equals("0 0")) break;
            st = new StringTokenizer(line, " ");
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            gr = new int[h][w];

            for(int i = 0 ; i < h ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < w ; j++) {
                    gr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0 ; i < h ; i++) {
                for (int j = 0; j < w; j++) {
                    if (gr[i][j] == 1) {
                        cnt++;
                        dfs(i, j, h, w);
                    }
                }
            }
            bw.write(String.valueOf(cnt) + "\n");
            cnt = 0;
        }
        bw.flush();
        bw.close();

    }
}