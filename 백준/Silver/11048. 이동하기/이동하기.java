import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int cnt = 0;

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i < n ; i++) {
            arr[i][0] += arr[i-1][0];
        }
        for(int j = 1 ; j < m ; j++) {
            arr[0][j] += arr[0][j-1];
        }
        for(int i = 1 ; i < n ; i++) {
            for(int j = 1 ; j < m ; j++) {
                arr[i][j] += Math.max(arr[i-1][j], Math.max(arr[i][j-1], arr[i-1][j-1]));
            }
        }
        System.out.println(arr[n-1][m-1]);
    }
}