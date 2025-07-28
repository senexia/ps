import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static int[][] arr;
    public static int cnt;
    public static void dfs(int x, int y, int m, int n) {
        arr[x][y] = 0;
        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == 1) {
                arr[nx][ny] = 0;
                dfs(nx, ny, m, n);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < tc ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            cnt = 0;

            for(int j = 0 ; j < k ; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int t1 = Integer.parseInt(st.nextToken());
                int t2 = Integer.parseInt(st.nextToken());
                arr[t1][t2] = 1;
            }
            for(int p = 0 ; p < m ; p++) {
                for(int q = 0 ; q < n ; q++) {
                    if(arr[p][q] == 1) {
                        cnt++;
                        dfs(p, q, m, n);
                    }
                }
            }
            bw.write(String.valueOf(cnt) + "\n");
        }


        bw.flush();
        bw.close();
    }
}