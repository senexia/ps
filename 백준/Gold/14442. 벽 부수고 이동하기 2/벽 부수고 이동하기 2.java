import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, res;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int[][][] dist;
    static boolean[][][] v;
    static boolean arrived = false;

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        v[0][0][0] = true;
        q.offer(new int[] {0, 0, 1, 0});
        //                 x  y dep wall
        //              이 x y까지의 거리
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int depth = p[2];
            int w = p[3];

            if(x == n - 1 && y == m - 1) {
                arrived = true;
                res = depth;
                return;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m && w <= k) {
                    if(arr[nx][ny] == 0 && !v[nx][ny][w]) {
                        //땅인 경우
                        v[nx][ny][w] = true;
                        q.offer(new int[] {nx, ny, depth + 1, w});
                    } else if(arr[nx][ny] == 1) {
                        //벽인 경우
                        if(w < k && !v[nx][ny][w+1]) {
                            //더 부술 수 있는 경우
                            v[nx][ny][w+1] = true;
                            q.offer(new int[] {nx, ny, depth + 1, w+1});
                        }



                    }
                }


            }

        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        v = new boolean[n][m][k + 1];

        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs();
        if(!arrived) System.out.println(-1);
        else System.out.println(res);
    }
}