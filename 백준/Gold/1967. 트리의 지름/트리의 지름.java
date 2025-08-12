import java.io.*;
import java.util.*;


class Edge implements Comparable<Edge> {
    int node;
    int cost;

    public Edge(int n, int c) {
        this.node = n;
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
    static boolean[] v;
    static int[] dist;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static void dijkstra() {
        while(!pq.isEmpty()) {
            Edge e = pq.poll();
            int cv = e.node;
            if(v[cv]) continue;
            v[cv] = true;
            for(Edge next : g[cv]) {
                if(dist[next.node] > dist[cv] + next.cost) {
                    dist[next.node] = dist[cv] + next.cost;
                    pq.offer(new Edge(next.node, dist[next.node]));
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        g = new List[n + 1];
        for(int i = 0 ; i < n + 1 ; i++) g[i] = new ArrayList<>();
        v = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, 1010101010);
        while(true) {
            String s = br.readLine();
            if(s == null || s.isEmpty()) break;
            st = new StringTokenizer(s, " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Edge(b, c));
            g[b].add(new Edge(a, c));
        }
        pq.offer(new Edge(1, 0));
        dist[1] = 0;
        dijkstra();
        //루트에서 최장거리 찾기 위한 다익



        int max = -1;
        int argmax = -1;
        for(int i = 1 ; i < n + 1 ; i++) {
            if(max < dist[i]) {
                max = dist[i];
                argmax = i;
            }
            dist[i] = 1010101010;
            v[i] = false;
        }
        pq.offer(new Edge(argmax, 0));
        dist[argmax] = 0;
        dijkstra();
        //루트로부터 최장거리인 노드로부터 다익 -> 젤 긴게 지름



        max = -1;
        for(int i = 1 ; i < n + 1 ; i++) {
            if(max < dist[i]) max = dist[i];
        }
        System.out.println(max);
    }
}