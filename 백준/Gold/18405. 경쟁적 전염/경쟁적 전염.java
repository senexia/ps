import java.io.*;
import java.util.*;

public class Main {
    static int n, k, tX, tY;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] v;
    static TreeMap<Integer, List<int[]>> tm = new TreeMap<>();
    static Queue<int[]> q = new ArrayDeque<>();

    static void bfs(int timeLimit) {
        while(!q.isEmpty()) {
            int[] xyt = q.poll();
            int cx = xyt[0];
            int cy = xyt[1];
            int cd = xyt[2];
            if(cd == timeLimit) return;
            v[cx][cy] = true;
            for(int i = 0 ; i < 4 ; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny]) {
                    v[nx][ny] = true;
                    arr[nx][ny] = arr[cx][cy];
                    q.offer(new int[] {nx, ny, cd + 1});
                }
            }

        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        //바이러스 종류 개수

        arr = new int[n][n];
        v = new boolean[n][n];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                int tok = Integer.parseInt(st.nextToken());
                arr[i][j] = tok;

                if(tok != 0) {
                    tm.putIfAbsent(tok, new ArrayList<>()); //첫좌표의 경우 리스트 생성

                    List<int[]> t = tm.get(tok);
                    t.add(new int[] {i, j});
                    v[i][j] = true;
                    //각 바이러스 숫자별 좌표를 리스트에 저장
                    //정렬은 Treemap이 해줌
                }
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        tX = Integer.parseInt(st.nextToken());
        tY = Integer.parseInt(st.nextToken());

        while(!tm.isEmpty()) {
            int fk = tm.firstKey();
            List<int[]> t = tm.get(fk);
            for(int[] a : t) {
                int x = a[0];
                int y = a[1];
                q.offer(new int[] {x, y, 0});
            }
            tm.remove(fk);
        }
        if(q.isEmpty()) {
            //큐가 비어있음
            //= 애초에 입력된 바이러스가 없음
            //= 시간 지나도 전염 없으니 그냥 0
            System.out.println(0);
            return;
        }
        bfs(s);
        System.out.println(arr[tX - 1][tY - 1]);

    }
}