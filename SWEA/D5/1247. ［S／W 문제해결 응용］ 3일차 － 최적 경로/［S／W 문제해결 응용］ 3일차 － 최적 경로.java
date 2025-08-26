import java.io.*;
import java.util.*;

public class Solution {
    static int[] x;
    static int[] y;
    static boolean[] v;
    static int min;
    static int n;

    static void perm(int cnt, int curr, int dist) {
        if(cnt == n) {
            int d = dist + Math.abs(x[curr] - x[1]) + Math.abs(y[curr] - y[1]);
            if(min > d) min = d;
            return;
        }

        for(int i = 2 ; i < n + 2 ; i++) {
            if(v[i]) continue;
            v[i] = true;
            int d = dist + Math.abs(x[curr] - x[i]) + Math.abs(y[curr] - y[i]);
            perm(cnt + 1, i, d);
            v[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= tc ; t++) {
            sb.append("#").append(t).append(" ");
            n = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;

            x = new int[n + 2];
            y = new int[n + 2];
            v = new boolean[n + 2];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < n + 2 ; i++) {
                x[i] = Integer.parseInt(st.nextToken());
                y[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 2 ; i < n + 2 ; i++) {
                int d = Math.abs(x[0] - x[i]) + Math.abs(y[0] - y[i]);
                v[i] = true;
                perm(1, i, d);
                v[i] = false;
            }
            sb.append(min).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}