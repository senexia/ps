import java.io.*;
import java.util.*;


class Edge implements Comparable<Edge> {
    int v;
    long c;
    public Edge (int v, long c) {
        this.v = v;
        this.c = c;
    }
    @Override
    public int compareTo(Edge e) {
        return Long.compare(this.c, e.c);
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
        int k = Integer.parseInt(st.nextToken());
        long[] dist = new long[n + 1];
        List<List<Edge>> g = new ArrayList<>();

        Arrays.fill(dist, Long.MAX_VALUE);
        for(int i = 0 ; i < n + 1 ; i++) g.add(new ArrayList<>());

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            g.get(b).add(new Edge(a, c));
        }

        //멀티 소스 다익
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            dist[a] = 0;
            pq.offer(new Edge(a, 0));
        }

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            long cc = curr.c;
            int cv = curr.v;
            if(dist[cv] < cc) continue;

            for(Edge e : g.get(cv)) {
                long nc = e.c;
                int nv = e.v;
                if(dist[nv] > dist[cv] + nc) {
                    dist[nv] = dist[cv] + nc;
                    pq.offer(new Edge(nv, dist[nv]));
                }
            }
        }
        long max = Long.MIN_VALUE;
        int argmax = -1;
        for(int i = 1 ; i < n + 1 ; i++) {
            if(max < dist[i]) {
                max = dist[i];
                argmax = i;
            }
        }
        sb.append(argmax).append("\n").append(max);
        System.out.println(sb);

    }
}