import java.util.*;
import java.io.*;

public class Main {
    static String[][] map;
    static int n;
    static int m;
    static int friends = 0;
    static Queue<int[]> q;
    static boolean[][] v;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static void bfs(int r, int c) {
        q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        v[r][c] = true;
        while(!q.isEmpty()) {
            int[] a = q.poll();
            if(map[a[0]][a[1]].equals("P")) friends++;
            for(int i = 0 ; i < 4 ; i++) {
                int nx = a[0] + dx[i];
                int ny = a[1] + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && !v[nx][ny] && !map[nx][ny].equals("X")) {
                    q.offer(new int[] {nx, ny});
                    v[nx][ny] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int doR = 0;
        int doC = 0;

        map = new String[n][m];
        v = new boolean[n][m];

        for(int i = 0 ; i < n ; i++) {
            String l = br.readLine();
            if(l.contains("I")) {
                doR = i;
                doC = l.indexOf("I");
            }
            map[i] = l.split("");
        }
        bfs(doR, doC);
        if(friends == 0) System.out.println("TT");
        else System.out.println(friends);





    }
}