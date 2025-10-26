import java.io.*;
import java.util.*;

public class Main {
    /*
    1. 먼지칸 전부 큐에 넣고 일단 다 0으로 바꿈

    2. 큐에서 빼면서 확산

    3. 배열돌리기

    만약 특정 규칙이 있다면 먼지가 있는 칸의 좌표만 담고있는 큐 내지는 리스트를 두면
    조금 더 효율적일 수 있으나 어차피 T가 커질수록 전체에 퍼지게 되니 n^2에 가까워짐
    -> 별도 관리 없이 그냥 다 돌면서 확인


     */
    static int r, c;
    static int air1 = -1;
    static int air2 = -1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    //              (val, x, y)
    static ArrayDeque<Integer> rq = new ArrayDeque<>();

    static void init() {
        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                if(arr[i][j] == 0 || arr[i][j] == -1) continue;

                q.offer(new int[] {arr[i][j], i, j});
                arr[i][j] = 0;
            }
        }
    }

    static void spread() {
        while(!q.isEmpty()) {
            int[] t = q.poll();
            int v = t[0];
            int residue = v / 5;
            int x = t[1];
            int y = t[2];

            int cnt = 0;
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < r && ny >= 0 && ny < c && arr[nx][ny] != -1) {
                    cnt++;
                }
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < r && ny >= 0 && ny < c && arr[nx][ny] != -1) {
                    arr[nx][ny] += residue;
                }
            }
            arr[x][y] += v - residue * cnt;
        }
    }

    static void rot() {
        //위에꺼 전부 넣기
        int idx = 1;
        while(idx < c) {
            rq.offer(arr[air1][idx]);
            arr[air1][idx++] = 0;
        }
        idx = air1 - 1;
        while(idx >= 0) {
            rq.offer(arr[idx][c - 1]);
            arr[idx--][c - 1] = 0;
        }
        idx = c - 2;
        while(idx >= 0) {
            rq.offer(arr[0][idx]);
            arr[0][idx--] = 0;
        }
        idx = 1;
        while(idx < air1) {
            rq.offer(arr[idx][0]);
            arr[idx++][0] = 0;
        }

        //위에꺼 한칸 돌리기
        //한칸 돌린거니까 1이아니라 2부터시작
        idx = 2;
        while(idx < c) {
            arr[air1][idx++] = rq.poll();
        }
        idx = air1 - 1;
        while(idx >= 0) {
            arr[idx--][c - 1] = rq.poll();
        }
        idx = c - 2;
        while(idx >= 0) {
            arr[0][idx--] = rq.poll();
        }
        idx = 1;
        while(idx < air1) {
            arr[idx++][0] = rq.poll();
        }
        rq.clear();



        //아래꺼 전부 넣기
        idx = 1;
        while(idx < c) {
            rq.offer(arr[air2][idx]);
            arr[air2][idx++] = 0;
        }
        idx = air2 + 1;
        while(idx < r) {
            rq.offer(arr[idx][c - 1]);
            arr[idx++][c - 1] = 0;
        }
        idx = c - 2;
        while(idx >= 0) {
            rq.offer(arr[r - 1][idx]);
            arr[r - 1][idx--] = 0;
        }
        idx = r - 2;
        while(idx > air2) {
            rq.offer(arr[idx][0]);
            arr[idx--][0] = 0;
        }

        //아래꺼 한칸 돌리기
        idx = 2;
        while(idx < c) {
            arr[air2][idx++] = rq.poll();
        }
        idx = air2 + 1;
        while(idx < r) {
            arr[idx++][c - 1] = rq.poll();
        }
        idx = c - 2;
        while(idx >= 0) {
            arr[r - 1][idx--] = rq.poll();
        }
        idx = r - 2;
        while(idx > air2) {
            arr[idx--][0] = rq.poll();
        }
        rq.clear();
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        for(int i = 0 ; i < r ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < c ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1 && air1 == -1) {
                    air1 = i;
                    air2 = i + 1;
                }
            }
        }



        for(int k = 0 ; k < t ; k++) {
            init();
            spread();
//            for(int[] a : arr) System.out.println(Arrays.toString(a));
            rot();
//            System.out.println();
//            for(int[] a : arr) System.out.println(Arrays.toString(a));

        }
        //50 * 50 * 1000 인트 ok
        int sum = 0;
        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                if(arr[i][j] == -1) continue;

                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
}