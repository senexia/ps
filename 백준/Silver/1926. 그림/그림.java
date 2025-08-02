import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int max = -1; //사이즈 최대
    static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        int cnt = 0;
        q.offer(new int[] {x, y});
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int a = temp[0];
            int b = temp[1];
            arr[a][b] = 0;
            cnt++;
            for(int i = 0 ; i < 4 ; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != 0) {
                    q.offer(new int[] {nx, ny});
                    arr[nx][ny] = 0;
                }
            }
        }
        if(max < cnt) max = cnt;

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int comp = 0;

        arr = new int[n][m];

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(arr[i][j] != 0) {
                    comp++;
                    bfs(i, j);
                }
            }
        }

        if(comp == 0) {
            System.out.println("0\n0");
        } else {
            sb.append(comp).append("\n").append(max);
            System.out.print(sb);
        }

    }


}