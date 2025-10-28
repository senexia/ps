import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] arr = new int[n][m];
        boolean[][][] v = new boolean[n][m][2];

        ArrayDeque<int[]> q = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //                x   y  d  k   (k=0 칼없음 k=1 칼있음)
        q.offer(new int[] {0, 0, 0, 0});
        v[0][0][0] = true;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int d = temp[2];
            int k = temp[3];

            //종료조건
            if(x == n - 1 && y == m - 1) {
                System.out.println(d);
                return;
            }
            //칼 먹었는지 갱신 후 방문배열 초기화
            if(arr[x][y] == 2) {
                k = 1;
//                arr[x][y] = 0;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0|| ny >= m || v[nx][ny][k] || d + 1 > t) continue;

                if(k == 0) {
                    if(arr[nx][ny] != 1) {
                        v[nx][ny][k] = true;
                        q.offer(new int[] {nx, ny, d + 1, k});
                    }
                } else {
                    v[nx][ny][k] = true;
                    q.offer(new int[] {nx, ny, d + 1, k});
                }
            }

        }
        System.out.println("Fail");
        /*
        테케 2번 -> 시간을 다 채우기 전에 큐가 비어버림 (방문배열이 다 true로 변해서 큐에 더 들어가지 않음)
        이 경우를 커버하기 위해 while문 밖에도 종료조건
         */
    }
}