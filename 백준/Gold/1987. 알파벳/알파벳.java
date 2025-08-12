import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[] alpha;
    static int[][] arr;
    static boolean[][] v;

    static int max = -1;
    static void dfs(int i, int j) {
//        System.out.println(i + " " + j);
        int fail = 0;
        v[i][j] = true;
        alpha[arr[i][j]] = true;
        for(int t = 0 ; t < 4 ; t++) {
            int nx = i + dx[t];
            int ny = j + dy[t];
            if(nx >= 0 && nx < r && ny >= 0 && ny < c && !v[nx][ny] && !alpha[arr[nx][ny]]) {
                dfs(nx, ny);
            } else {
                fail++;
            }
        }
        if(fail == 4) {
            //4방향 전부 안됨 -> 더이상 갈 수 있는 곳이 없다 -> 가지의 마지막
            int cnt = 0;
            for(boolean b : alpha) {
                if(b) cnt++;
            }
            if(max < cnt) max = cnt;
        }
        //왔던길 제거
        v[i][j] = false;
        alpha[arr[i][j]] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[r][c];
        v = new boolean[r][c];
        alpha = new boolean[26];
        for(int i = 0 ; i < r ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < c ; j++) {
                arr[i][j] = s.charAt(j) - 'A';
            }
        }
        dfs(0, 0);
        System.out.println(max);


    }
}