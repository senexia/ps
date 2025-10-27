import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int s;
        int e;
        int c;
        public Edge(int s, int e, int c) {
            this.s = s;
            this.e = e;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[1] = 0;
        Edge[] edge = new Edge[m];
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edge[i] = new Edge(a, b, c);
        }

        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 0 ; j < m ; j++) {
                Edge e = edge[j];
                if(dist[e.s] == Long.MAX_VALUE) continue;

                if(dist[e.e] > dist[e.s] + e.c) {
                    dist[e.e] = dist[e.s] + e.c;
                    if(i == n) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        for(int i = 2 ; i < n + 1 ; i++) {
            sb.append(dist[i] == Long.MAX_VALUE ? -1 : dist[i]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);

    }
}