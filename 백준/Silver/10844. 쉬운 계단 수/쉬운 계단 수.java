import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[10][101];
        for(int i = 0 ; i < 10 ; i++) {
            d[i][1] = 1;
        }
        d[0][1] = 0;
        int mod = 1000000000;
        for(int i = 2 ; i < 101 ; i++) {
            d[0][i] = d[1][i-1];
            d[9][i] = d[8][i-1];
            for(int j = 1 ; j <= 8 ; j++) {
                d[j][i] = (d[j-1][i-1] + d[j+1][i-1]) % mod;
            }
        }
        long sum = 0;
        for(int i = 0 ; i < 10 ; i++) {
            sum = (sum + d[i][n]) % mod;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}