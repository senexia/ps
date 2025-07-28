import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sd = new StringBuilder();
    static String[][] arr;
    static boolean[][] v;
    static int n;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y) {
        String fs = arr[x][y];
        v[x][y] = true;
        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny] && arr[nx][ny].equals(fs)) {
                dfs(nx, ny);
            }
        }
    }

    static void blind() {
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(arr[i][j].equals("R")) arr[i][j] = "G";
            }
        }
        for(boolean[] b : v) Arrays.fill(b, false);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        arr = new String[n][n];
        v = new boolean[n][n];
        int section = 0;

        for(int i = 0 ; i < n ; i++) {
            arr[i] = br.readLine().split("");
        }

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(!v[i][j]) {
                    section++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(section);
        section = 0;
        blind();
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(!v[i][j]) {
                    section++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(section);
    }
}