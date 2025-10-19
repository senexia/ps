import java.io.*;
import java.util.*;

public class Main {
    static int cnt = 0;
    static int n, m, sx, sy, dir;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;

    static int nextdir(int d) {
        if(d == 0) return 3;
        else if(d == 1) return 0;
        else if(d == 2) return 1;
        else return 2;
    }

    static void rbcs(int x, int y, int dir) {
        while(true) {
            //현재칸 청소 (1)
            if(arr[x][y] == 0) {
                cnt++;
                arr[x][y] = 2;
            }

            //주변확인
            int adj = 0;
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) adj++;
            }

            //청소 가능 칸 없음 (2)
            if(adj == 0) {
                int nx = x - dx[dir];
                int ny = y - dy[dir];
                //후진가능 (2-1)
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != 1) {
                    x = nx;
                    y = ny;
                } else {
                    //후진못함 (2-2)
                    System.out.println(cnt);
                    return;
                }
            } else {
                //청소가능칸 있음
                for(int i = 0 ; i < 4 ; i++) {
                    //회전
                    dir = nextdir(dir);
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                        //청소 안된칸이면 전진
                        x = nx;
                        y = ny;
                        break;
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

        st = new StringTokenizer(br.readLine(), " ");
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rbcs(sx, sy, dir);

    }
}