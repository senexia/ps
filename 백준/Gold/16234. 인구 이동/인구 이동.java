import java.io.*;
import java.util.*;

public class Main {
    /*
    1. 각 칸 돌면서 bfs로 그루핑

    2. 그룹별 합 n빵 후 갱신

    3. 1, 2를 반복. 1에서 그루핑이 된게 없다면 완료된거


     */

    static int n, l, r, id;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] group;
    static int[][] arr;
    static boolean[][] v;
    static HashMap<Integer, Integer> sumById;
    static HashMap<Integer, Integer> cntById;
    static ArrayDeque<int[]> q = new ArrayDeque<>();

    static void gp(int i, int j, int id) {
        v[i][j] = true;
        group[i][j] = id;
        sumById.put(id, arr[i][j]);
        cntById.put(id, 1);
        q.offer(new int[]{i, j});
        while(!q.isEmpty()) {
            int[] temp = q.poll();

            int x = temp[0];
            int y = temp[1];
            for(int k = 0 ; k < 4 ; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny]) {
                    int diff = Math.abs(arr[x][y] - arr[nx][ny]);

                    if(l <= diff && diff <= r) {
                        v[nx][ny] = true;
                        group[nx][ny] = id;
                        q.offer(new int[] {nx, ny});
                        sumById.put(id, sumById.get(id) + arr[nx][ny]);
                        cntById.put(id, cntById.get(id) + 1);
                    }
                }
            }
        }
    }

    static void updateWithReset() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                int id = group[i][j];
                group[i][j] = 0;
                v[i][j] = false;

                int sum = sumById.get(id);
                int cnt = cntById.get(id);
                int val = sum / cnt;
                arr[i][j] = val;
            }
        }
        sumById.clear();
        cntById.clear();
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        group = new int[n][n];
        v = new boolean[n][n];
        sumById = new HashMap<>();
        cntById = new HashMap<>();

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;

        while(true) {
            for(int i = 0 ; i < n ; i++) {
                for(int j = 0 ; j < n ; j++) {
                    if(v[i][j]) continue;

                    gp(i, j, id);
                    id++;
                }
            }
//            for(int[] a : group) System.out.println(Arrays.toString(a));
            //그룹이 n^2개면 각각이 전부 1개짜리 그룹 -> 갱신된게 없으므로 종료
            if(sumById.size() == n * n) break;
            updateWithReset();
            day++;
        }
        System.out.println(day);
    }
}