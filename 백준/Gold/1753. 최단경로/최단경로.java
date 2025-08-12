import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int v;
    int cost;

    public Edge(int v, int c) {
        this.v = v;
        this.cost = c;
    }
    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost);
    }
}

public class Main {
    static int n;
    static List<Edge>[] g;
    static int[] dist;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    static void dijkstra() {
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            int cv = cur.v;
            int cc = cur.cost;
            if(dist[cv] < cc) continue;
            for(Edge edge : g[cv]) {
                if(dist[edge.v] > dist[cv] + edge.cost) {
                    dist[edge.v] = dist[cv] + edge.cost;
                    pq.offer(new Edge(edge.v, dist[edge.v]));
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        g = new List[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0 ; i < n + 1 ; i++) g[i] = new ArrayList<>();
        int start = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b, c));
        }

        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        dijkstra();
        for(int i = 1 ; i < n + 1 ; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}