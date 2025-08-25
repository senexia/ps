import java.io.*;
import java.util.*;

public class Solution {
    static int[] uf;
    static int find(int x) {
        if(x == uf[x]) return x;
        return uf[x] = find(uf[x]);
    }

    static void union(int x, int y) {
        int a = find(x);
        int b = find(y);

        if(a != b) uf[b] = a;
    }

    static int chk(int x, int y) {
        int a = find(x);
        int b = find(y);

        if(a == b) return 1;
        else return 0;
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
                int c = Integer.parseInt(st.nextToken());

                if(a == 0) union(b, c);
                else {
                    sb.append(chk(b, c));
                }
            }
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}