import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        int ret = 0;


        int tc = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= tc ; t++) {
            sb.append("#").append(t).append(" ");
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int[][] dist = new int[n][n];

            for(int[] d : dist) Arrays.fill(d, Integer.MAX_VALUE);

            for(int i = 0 ; i < n ; i++) {
                String s = br.readLine();
                for(int j = 0 ; j < n ; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
            dist[0][0] = 0;
            pq.offer(new int[] {0, 0, 0});
            while(!pq.isEmpty()) {
                int[] temp = pq.poll();

                int x = temp[0];
                int y = temp[1];
                int c = temp[2];

                if(x == n - 1 && y == n - 1) break;

                for(int i = 0 ; i < 4 ; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if(dist[nx][ny] < arr[nx][ny]) continue;

                        if(dist[nx][ny] > dist[x][y] + arr[nx][ny]) {
                            dist[nx][ny] = dist[x][y] + arr[nx][ny];
                            pq.offer(new int[] {nx, ny, dist[nx][ny]});
                        }
                    }
                }

            }
            sb.append(dist[n - 1][n - 1]).append("\n");
            pq.clear();
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}