import java.io.*;
import java.util.*;


public class Solution {
    static int max = 0;
    static int argx = 0;
    static int argy = 0;
    static int n;
    static boolean flag = false;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] v;

    static void dfs(int x, int y, int d, int hash) {
        v[x][y] = true;
        int fail = 0;
        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < n && ny >= 0 && ny < n && !v[nx][ny] && arr[nx][ny] == arr[x][y] + 1) {
                dfs(nx, ny, d + 1, hash);
            } else {
                fail++;
            }
        }
        if(fail == 4 && max < d) {
            max = d;
            argx = invx(hash);
            argy = invy(hash);
        }
        v[x][y] = false;
    }
    static int hash(int x, int y) {
        return (x << 16) | y;
    }
    static int invx(int hash) {
        return hash >> 16;
    }
    static int invy(int hash) {
        return hash & 0xFFFF;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        //        n    ,  좌표해시
        for(int t = 0 ; t < tc ; t++) {
            sb.append("#").append(t+1).append(" ");
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            v = new boolean[n][n];
            max = 0;
            argx = 0;
            argy = 0;
            for(int i = 0 ; i < n ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < n ; j++) {
                    int tok = Integer.parseInt(st.nextToken());
                    arr[i][j] = tok;
                    tm.put(tok, hash(i, j));
                }
            }
            while(!tm.isEmpty()) {
                int fk = tm.firstKey();
                int coord = tm.get(fk);
                if(fk > n * n - max) break;
                //아래에서부터 위로 돌면
                //1. 같은 값 만낫을 때 작은 값 찍는다는 조건 충족 가능
                //2. 뽑는 수가 max보다 크면 최대한 길게 움직여도 max보다 작으니 프루닝 가능
                int x = invx(coord);
                int y = invy(coord);
                dfs(x, y, 1, coord);
                tm.remove(fk);
            }
            sb.append(arr[argx][argy]).append(" ").append(max).append("\n");
            tm.clear();
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);


    }
}