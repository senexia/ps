import java.io.*;
import java.util.*;
class Edge implements Comparable<Edge>{
    public int x;
    public int y;
    public int cost;

    public Edge(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost);
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int cnt = 1;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            int[][] arr = new int[n][n];
            int[][] dist = new int[n][n];
            boolean[][] v = new boolean[n][n];
            PriorityQueue<Edge> pq = new PriorityQueue<>();

            for(int i = 0 ; i < n ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < n ; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = 999999999;
                }
            }
            pq.offer(new Edge(0, 0, 0));
            dist[0][0] = 0;
            while(!pq.isEmpty()) {
                Edge curr = pq.poll();
                int cx = curr.x;
                int cy = curr.y;
                if(v[cx][cy]) continue;

                v[cx][cy] = true;
                for(int i = 0 ; i < 4 ; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if(dist[nx][ny] > dist[cx][cy] + arr[nx][ny]) {
                            dist[nx][ny] = dist[cx][cy] + arr[nx][ny];
                            pq.add(new Edge(nx, ny, dist[nx][ny]));
                        }
                    }
                }
            }
            sb.append("Problem ").append(cnt).append(": ").append(dist[n-1][n-1] + arr[0][0]).append("\n");
            cnt++;
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}