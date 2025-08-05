import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][][] v;
    static boolean isReachable = false;
    static void bfs(int x, int y, int depth, int wall) {
        Queue<int[]> q = new ArrayDeque<>();
        v[x][y][wall] = true;
        q.offer(new int[] {x, y, depth, wall});
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            if(temp[0] == n - 1 && temp[1] == m - 1) {
                isReachable = true;
                arr[n-1][m-1] = temp[2];
                return;
            }
            for(int i = 0 ; i < 4 ; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                //범위 먼저 확인
                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int nd = temp[2] + 1;
                    int w = temp[3];


                    //벽아님
                    if(arr[nx][ny] != 1 && !v[nx][ny][w]) {
                        v[nx][ny][w] = true;
                        q.offer(new int[] {nx, ny, nd, w});
                    } else if(arr[nx][ny] == 1) {
                        //벽이면
                        //벽을 깰 수 있는지를 확인
                        if(w == 0 && !v[nx][ny][1]) {
                            v[nx][ny][1] = true;
                            q.offer(new int[] {nx, ny, nd, 1});
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
        arr = new int[n][m];
        v = new boolean[n][m][2];
        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0, 1, 0);
        if(isReachable) System.out.println(arr[n-1][m-1]);
        else System.out.println(-1);
        //맵에 거리를 별도로 쓰지 않고 큐로 관리하되 마지막 도달했을때만 특별히 마지막 지점에 거리 기록
        //즉, 도달했으면 도착점 출력, 아니면 -1
    }
}