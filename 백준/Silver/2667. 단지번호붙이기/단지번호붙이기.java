import java.io.*;
import java.util.*;


public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int cnt;
    static int s;
    static ArrayList<Integer> l;
    public static void dfs(int x, int y, int n) {
        arr[x][y] = 0;
        s++;
        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
                dfs(nx, ny, n);
            }
        }
    }

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        l = new ArrayList<>();
        cnt = 0;
        s = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        String[] ipt = new String[n];

        for(int i = 0 ; i < n ; i++) {
            //st = new StringTokenizer(br.readLine(),"");
            ipt = br.readLine().split("");
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = Integer.parseInt(ipt[j]);
            }
        }
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(arr[i][j] == 1) {
                    cnt++;
                    dfs(i, j, n);
                    l.add(s);
                    s = 0;
                }
            }
        }
        bw.write(String.valueOf(cnt) + "\n");
        Collections.sort(l);
        for(int i : l) bw.write(String.valueOf(i) + "\n");
        bw.flush();
        bw.close();
    }
}