import java.io.*;
import java.util.*;

public class Main {
    /*
    최악 경우 N = 50 -> 맵 크기 2500
    M = 10

    2n C k가 최대일 때는 k = n일 때고
    중심이항계수 근사로부터 2n C n은  4^n / 4 = 2^(2n - 2) 정도 된다. (  4^n / sqrt(pi * n)  )

    m = 10 -> n = 5 -> 10 C 5 ~ 256

    무지성으로 BFS를 직접 10C5번 한다고 치면 :

    방문배열 초기화 n^2, 탐색도 대충 러프하게 n^2이라하면
    아주 러프하게
    2500 * 2 * 256 < 2500 * 4 * 256
                   < 256 * 10000
                   = 2560000
    이므로 그냥 널널하네
    굿
     */
    static int n, m, left;
    static int min = Integer.MAX_VALUE;
    static ArrayList<int[]> virus;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] num;
    static int[] choose;
    static int[][] arr;

    static void bfs(int[] idx) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        //         x y t
        int remain = left;

        for(int i = 0 ; i < idx.length ; i++) {
            int[] temp = virus.get(idx[i]);
            q.offer(new int[] {temp[0], temp[1], 0});
        }

        boolean[][] v = new boolean[n][n];
//        int[][] map = new int[n][n];
//        for(int i = 0 ; i < n ; i++) {
//            for(int j = 0 ; j < n ; j++) {
//                map[i][j] = arr[i][j];
//            }
//        }

        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            int d = temp[2];
            for(int i = 0 ; i < 4 ; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny] && arr[nx][ny] != 1) {
                    v[nx][ny] = true;

                    if(arr[nx][ny] == 0) remain--;
                    //바이러스끼리도 전염되는거 빼먹어서 틀린듯
                    if(remain == 0) {
                        //남은게 없다 -> min 갱신 시도 후 종료
                        if(min > d + 1) min = d + 1;
                        return;
                    }
                    q.offer(new int[] {nx, ny, d + 1});
                }
            }

        }


    }
    static void comb(int start, int cnt) {
        if(cnt == m) {
            bfs(choose);
            return;
        }

        for(int i = start ; i < virus.size() ; i++) {
            choose[cnt] = num[i];
            comb(i + 1, cnt + 1);
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        virus = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int zeros = 0;


        arr = new int[n][n];

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) zeros++;
                if(arr[i][j] == 2) virus.add(new int[] {i, j});
            }
        }
        left = zeros;
        if(zeros == 0) {
            System.out.println(0);
            return;
        }

        num = new int[virus.size()];
        choose = new int[m];
        for(int i = 0 ; i < num.length ; i++) num[i] = i;

        comb(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? "-1" : min);
    }
}
