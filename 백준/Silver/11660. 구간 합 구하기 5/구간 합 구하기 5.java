import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];
        int[][] sum = new int[n+1][n+1];

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < n + 1 ; i++) {
            sum[i][0] = 0;
            sum[0][i] = 0;
        }

        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 1 ; j < n + 1 ; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] + arr[i - 1][j - 1] - sum[i-1][j-1];
            }
        }
//        for(int[] b : sum) System.out.println(Arrays.toString(b));
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int ret = sum[x2][y2] - sum[x1 - 1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1];
            sb.append(i == m - 1 ? ret : ret + "\n");
        }
        System.out.println(sb);
    }
}