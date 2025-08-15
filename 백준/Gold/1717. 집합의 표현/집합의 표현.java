import java.io.*;
import java.util.*;

public class Main {
    static int[] member;
    static int find(int x) {
        if(x == member[x]) return x;
        else {
            return member[x] = find(member[x]);
        }
    }
    static boolean union(int x, int y) {
        if(x == y || find(x) == find(y)) return false;
        member[find(x)] = find(y);
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        member = new int[n + 1];
        for(int i = 0 ; i < n + 1 ; i++) member[i] = i;
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0) union(b, c);
            else {
                int x = find(b);
                int y = find(c);
                if(x == y) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        sb.setLength(sb.length() - 1);;
        System.out.print(sb);
    }
}