import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    static void rec(int x, int y, int len) {
        if(len == 1) {
            if(arr[x][y] == 0) sb.append(0);
            else sb.append(1);
            return;
        }
        int a = arr[x][y];
        boolean allSame = true;
        for(int i = x ; i < x + len ; i++) {
            for(int j = y ; j < y + len ; j++) {
                if(arr[i][j] != a) {
                    allSame = false;
                    break;
                }
            }
            if(!allSame) break;
        }

        if(allSame) {
            sb.append(a);
            return;
        }

        sb.append("(");
        rec(x, y, len/2);
        rec(x, y + len/2, len/2);
        rec(x + len/2, y, len/2);
        rec(x + len/2, y + len/2, len/2);
        sb.append(")");
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < n ; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        rec(0, 0, n);
        System.out.println(sb);
    }
}