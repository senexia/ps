import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};

        int tc = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < tc ; t++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");

            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            boolean[][] v = new boolean[n][n];
            ArrayDeque<int[]> q = new ArrayDeque<>();

            q.offer(new int[] {sx, sy, 0});
            v[sx][sy] = true;
            while(!q.isEmpty()) {
                int[] temp = q.poll();
                int x = temp[0];
                int y = temp[1];
                int d = temp[2];
                if(x == ex && y == ey) {
                    sb.append(d).append("\n");
                    break;
                }
                for(int i = 0 ; i < 8 ; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny]) {
                        v[nx][ny] = true;
                        q.offer(new int[] {nx, ny, d + 1});
                    }
                }
            }
//            System.out.println("loop end");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}