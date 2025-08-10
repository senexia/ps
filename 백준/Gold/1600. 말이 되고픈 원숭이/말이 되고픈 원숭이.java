import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] dx = {-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] arr;
    static boolean[][][] v;
    static int res = -1;

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0, 0, 0, 0});
                       // x  y depth jump
        while(!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            int dep = xy[2];
            int j = xy[3];
            v[x][y][j] = true;
            if(x == n - 1 && y == m - 1) {
                res = dep;
                return;
            }

            int upperbound = j < k ? dx.length : 4;
            //현재 점프 횟수와 점프 가능 횟수 (상한)을 비교하여
            //for문을 어디까지 돌릴지 정해둠
            for(int i = 0 ; i < upperbound ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                    if(i >= 4) {
                        //현재 스텝이 점프인지 확인
                        //없으면 일반 인접칸 이동인데도 점프로 카운트되는 문제
                        if(j < k && !v[nx][ny][j + 1]) {
                            //아직 점프를 더 할 수 있음
                            v[nx][ny][j + 1] = true;
                            q.offer(new int[] {nx, ny, dep + 1, j + 1});
                        } else if(j == k && !v[nx][ny][j]) {
                            //점프 상한 도달
                            v[nx][ny][j] = true;
                            q.offer(new int[] {nx, ny, dep + 1, j});
                        }
                    } else {
                        //점프가 아님
                        if(!v[nx][ny][j]) {
                            v[nx][ny][j] = true;
                            q.offer(new int[] {nx, ny, dep + 1, j});
                        }
                    }

                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        k = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        v = new boolean[n][m][k + 1];

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs();
        System.out.println(res);
    }
}