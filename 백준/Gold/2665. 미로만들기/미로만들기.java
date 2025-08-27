import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        char[][] arr = new char[n][n];
        boolean[][] v = new boolean[n][n];

        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        q.offer(new int[] {0, 0, 0});
        //                x  y   cnt
        v[0][0] = true;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int c = temp[2];

            if(x == n - 1 && y == n - 1) {
                System.out.println(c);
                return;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //0-1 bfs
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny]) {
                    v[nx][ny] = true;
                    if(arr[nx][ny] == '0') q.offerLast(new int[] {nx, ny, c + 1});
                    else q.offerFirst(new int[] {nx, ny, c});
                }
            }
        }


    }
}