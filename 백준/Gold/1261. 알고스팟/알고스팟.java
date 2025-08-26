import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        ArrayDeque<int[]> q = new ArrayDeque<>();
        //        x, y, cnt
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];
        boolean[][] v = new boolean[n][m];

        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        q.offer(new int[] {0, 0, 0});
        v[0][0] = true;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int c = temp[2];
            if(x == n - 1 && y == m - 1) {
                System.out.println(c);
                return;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !v[nx][ny]) {
                    v[nx][ny] = true;
                    if(arr[nx][ny] == '0') {
                        q.offerFirst(new int[] {nx, ny, c});
                    } else {
                        q.offerLast(new int[] {nx, ny, c + 1});
                    }
                }
            }
        }

    }
}