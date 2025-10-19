import java.io.*;
import java.util.*;

public class Main {
    static int n, bound, level, exp;
    static int cnt = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] v;
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]
    );

    static boolean find() {
        boolean find = false;
        bound = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int d = temp[2];
            if(0 < arr[x][y] && arr[x][y] < level && d <= bound) {
                bound = d;
                pq.offer(new int[] {x, y});
                find = true;
                continue;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] <= level && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new int[] {nx, ny, d + 1});
                }
            }
        }
        //못찾았으면 리턴
        if(!find) return false;

        //거리, 크기 갱신
        cnt += bound;
        exp++;
        //다시 큐에 넣을 정보 pq에서 뽑기
        int[] temp = pq.peek();
        int x = temp[0];
        int y = temp[1];
        int d = 0;

//        System.out.println("Move to : (" + x + ", " + y + ")");


        //모든 정보들 초기화
        pq.clear();
        q.clear();
        for(boolean[] vv : v) Arrays.fill(vv, false);

        //이동한 좌표 다시 큐에 넣기, 먹은 지점 0으로 바꾸기
        q.offer(new int[] {x, y, d});
        v[x][y] = true;
        arr[x][y] = 0;
        return true;
    }
    static void update() {
        if(exp == level) {
            exp = 0;
            level++;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        v = new boolean[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 9) {
                    q.offer(new int[] {i, j, 0});
                    v[i][j] = true;
                    arr[i][j] = 0;
                }
            }
        }

        level = 2;
        exp = 0;

        while(true) {
            if(!find()) {
                System.out.println(cnt);
                return;
            }

            update();
//            System.out.println("lev, exp : " + level + " " + exp);
        }
    }
}