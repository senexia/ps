import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int v;
    int c;
    public Edge(int v, int c) {
        this.v = v;
        this.c = c;
    }

    @Override
    public int compareTo(Edge e) {
        return Integer.compare(this.c, e.c);
    }
}


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        List<List<Edge>> g = new ArrayList<>();
        for(int i = 0 ; i < n + 1 ; i++) {
            g.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            g.get(a).add(new Edge(b, c));
            g.get(b).add(new Edge(a, c));
        }

        dist[1] = 0;
        pq.offer(new Edge(1, 0));
        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            int cc = curr.c;
            int cv = curr.v;
            if(cv == n) break;
            if(dist[cv] < cc) continue;

            for(Edge next : g.get(cv)) {
                int nc = next.c;
                int nv = next.v;
                if(dist[nv] > dist[cv] + nc) {
                    dist[nv] = dist[cv] + nc;
                    pq.offer(new Edge(nv, dist[nv]));
                }
            }
        }
        System.out.println(dist[n]);
    }
}