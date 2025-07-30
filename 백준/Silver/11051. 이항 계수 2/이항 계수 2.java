
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] comb = new int[n+1][n+1];
        for(int i = 0 ; i < n + 1 ; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;
        }
        for(int i = 2 ; i < n + 1 ; i++) {
            for(int j = 1 ; j < n ; j++) {
                comb[i][j] = (comb[i-1][j-1] % 10007 + comb[i-1][j] % 10007) % 10007;
            }
        }
        System.out.println(comb[n][k]);
    }
}