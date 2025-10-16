import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dist = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                int c = Integer.parseInt(st.nextToken());
                if(c == 1) {
                    dist[i][j] = Integer.MAX_VALUE;
                    q.offer(new int[] {i, j});
                }
            }
        }

        int max = -1;
        while(!q.isEmpty()) {
            int[] temp = q.poll();

            int x = temp[0];
            int y = temp[1];
            for(int i = 0 ; i < 8 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[x][y] == Integer.MAX_VALUE ? 1 : dist[x][y] + 1;
                    max = Math.max(max, dist[nx][ny]);
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        System.out.println(max);
    }
}