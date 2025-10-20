import java.io.*;
import java.util.*;

public class Main {
    static int n, m, fuel, tx, ty, px, py;
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]
    );
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] arr;
    static boolean[][] v;

    static int hash(int x, int y) {
        return 21 * x + y;
    }
    static int getX(int h) {
        return h / 21;
    }
    static int getY(int h) {
        return h % 21;
    }


    static int find() {
        int bound = Integer.MAX_VALUE;
        q.offer(new int[] {tx, ty, 0});
        v[tx][ty] = true;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int d = temp[2];
            if(arr[x][y] > 0 && d <= bound) {
                bound = d;
                pq.offer(new int[] {x, y, d});
                continue;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny] && arr[nx][ny] >= 0) {
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny, d + 1});
                }
            }

        }
        if(pq.isEmpty()) {
            bound = -1;
        } else {
            int[] dest = pq.poll();
            px = dest[0];
            py = dest[1];
            //손님 위치.
        }

        for(boolean[] vv : v) Arrays.fill(vv, false);
        q.clear();
        pq.clear();
        return bound;
    }


    static int move() {
        int hash = arr[px][py] - 1;
        int ex = getX(hash);
        int ey = getY(hash);
        int ret = -1;

        q.offer(new int[] {px, py, 0});
        v[px][py] = true;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int d = temp[2];
            if(x == ex && y == ey) {
                ret = d;
                break;
            }
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny] && arr[nx][ny] >= 0) {
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny, d + 1});
                }
            }
        }

        for(boolean[] vv : v) Arrays.fill(vv, false);
        q.clear();
        pq.clear();
        tx = ex;
        ty = ey;
        arr[px][py] = 0;
        //도착지로 택시위치 이동 및 원래 손님위치 0으로 변경
        return ret;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        v = new boolean[n][n];

        /*
        arr배열을 벽을 -1로 저장
        손님의 경우 손님이 있는 좌표에 목적지의 해시값을 저장
        따라서 arr[x][y] >= 0이면 탐색 가능하고 arr[x][y] > 0이면 손님인 것임
        이후 arr[x][y]값에서 getX, getY하면 목적지가 어딘지 나오므로, 이 지점에서 bfs하면
        이게 손님 기준 bfs하는거랑 같음

        근데 중요한건 손님의 출발지는 입력받고 -1을 해서 0-base로 해도 되지만
        도착지는 입력받고 -1을 해서 0-base로 하는 경우
        목적지가 (0, 0)일 때 해시값이 0이 나와서
        arr배열의 아무것도 없는 0과 구분이 안됨

        따라서 목적지는 1-base로 해싱하고, bfs할때 getX, getY한 뒤에 -1해서 0-base로 만들어주면 됨
         */
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = -Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        tx = Integer.parseInt(st.nextToken()) - 1;
        ty = Integer.parseInt(st.nextToken()) - 1;

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            arr[a][b] = hash(c, d) + 1;
        }
//        for(int[] a: arr) System.out.println(Arrays.toString(a));
        /*
        while(손님수 > 0 && 연료 > 0)
        1. taxi_bfs -> 손님까지의 최단거리 반환
        2. son_bfs -> 지정된 손님의 목적지까지의 거리 반환

        if(연료 < 소모1 + 소모2) -1출력 후 종료
        else 연료 = 연료 - 소모1 + 소모2
        손님수--
         */

        while(m > 0 && fuel >= 0) {
            int f1 = find();
            if(f1 == -1) {
                System.out.println(-1);
                return;
            }
            int f2 = move();
            if(f2 == -1) {
                System.out.println(-1);
                return;
            }
            //위의 두 분기 : 택시가 벽에 막혀서 못가는 경우 (테케 3)

            if(fuel < f1 + f2) {
                System.out.println(-1);
                return;
            }

            fuel = fuel - f1 + f2;
            m--;
        }
        System.out.println(fuel);
    }
}