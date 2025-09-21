import java.io.*;
import java.util.*;

public class Main {
    static int[] uf;
    static int find(int x) {
        if(x == uf[x]) return x;
        return uf[x] = find(uf[x]);
    }

    static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(a == b) return false;
        uf[a] = b;
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        uf = new int[v + 1];
        for(int i = 0 ; i < v + 1 ; i++) uf[i] = i;
        int[][] g = new int[e][3];
        for(int i = 0 ; i < e ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[i] = new int[] {from, to, c};
        }

        Arrays.sort(g, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        int sum = 0;
        int cnt = 0;
        for(int[] edge : g) {
            int v1 = edge[0];
            int v2 = edge[1];
            if(union(v1, v2)) {
                sum += edge[2];
                cnt++;
            }
            if(cnt == v - 1) break;
        }
        System.out.println(sum);
    }
}