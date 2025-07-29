
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] cost = new int[n][3];
        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 3 ; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i < n ; i++) {
            cost[i][0] = cost[i][0] + (int)Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] = cost[i][1] + (int)Math.min(cost[i-1][0], cost[i-1][2]);
            cost[i][2] = cost[i][2] + (int)Math.min(cost[i-1][0], cost[i-1][1]);
        }
        System.out.println(Math.min(Math.min(cost[n - 1][0],cost[n - 1][1]), cost[n - 1][2]));

    }
}