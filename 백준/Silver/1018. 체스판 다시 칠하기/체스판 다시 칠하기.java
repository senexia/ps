import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int[][] bd1 = {
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0}
        };
        int[][] bd2 = {
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0}
        };

        int n, m;
        int[][] arr;
        int min = Integer.MAX_VALUE;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = (s.charAt(j) == 'W' ? 0 : 1);
            }
        }

//        for(int[] a : arr) System.out.println(Arrays.toString(a));

        for(int i = 0 ; i <= n - 8 ; i++) {
            for(int j = 0 ; j <= m - 8 ; j++) {
                int cnt1 = 0;
                int cnt2 = 0;
                for(int p = 0 ; p < 8 ; p++) {
                    for(int q = 0 ; q < 8 ; q++) {
                        if(arr[i + p][j + q] != bd1[p][q]) cnt1++;
                        if(arr[i + p][j + q] != bd2[p][q]) cnt2++;
                    }
                }
                if(min > Math.min(cnt1, cnt2)) min = Math.min(cnt1, cnt2);
            }
        }
        System.out.println(min);
    }
}