import java.io.*;
import java.util.*;


public class Solution {
    static int[] uf;
    static int find(int x) {
        if(x == uf[x]) return x;

        return uf[x] = find(uf[x]);
    }

    static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(a == b) return false;

        uf[b] = find(a);
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= tc ; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            uf = new int[n + 1];
            for(int i = 1 ; i < n + 1 ; i++) {
                uf[i] = i;
            }
            for(int i = 0 ; i < m ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(union(a, b)) n--;
            }
            sb.append(n).append("\n");

        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}