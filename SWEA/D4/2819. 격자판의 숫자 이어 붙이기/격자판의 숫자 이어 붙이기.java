import java.io.*;
import java.util.*;

public class Solution {
    static HashSet<String> hs = new HashSet<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;

    static void dfs(int x, int y, String s) {
        if(s.length() == 7) {
            hs.add(s);
            return;
        }
        for(int i = 0 ; i < 4 ; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
                dfs(nx, ny, s + Integer.toString(arr[nx][ny]));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= tc ; t++) {
            sb.append("#").append(t).append(" ");

            arr = new int[4][4];
            for(int i = 0 ; i < 4 ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < 4 ; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0 ; i < 4 ; i++) {
                for(int j = 0 ; j < 4 ; j++) {
                    dfs(i, j, Integer.toString(arr[i][j]));
                }
            }
            sb.append(hs.size()).append("\n");
            hs.clear();
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}