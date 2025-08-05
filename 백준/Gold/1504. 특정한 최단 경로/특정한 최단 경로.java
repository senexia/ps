import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int v, cost;
    Edge(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static int n, e;
    static ArrayList<Edge>[] g;
    static final int INF = Integer.MAX_VALUE;

    static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        boolean[] v = new boolean[n + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int cv = curr.v;
            if (v[cv]) continue;
            v[cv] = true;

            for (Edge next : g[cv]) {
                if (dist[next.v] > dist[cv] + next.cost) {
                    dist[next.v] = dist[cv] + next.cost;
                    pq.offer(new Edge(next.v, dist[next.v]));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        g = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b, c));
            g[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] d1 = dijkstra(1);
        int[] d2 = dijkstra(v1);
        int[] d3 = dijkstra(v2);

        long p1 = (long) d1[v1] + d2[v2] + d3[n];
        long p2 = (long) d1[v2] + d3[v1] + d2[n];

        long res = Math.min(p1, p2);
        System.out.println(res >= INF ? -1 : res);
    }
}