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
    static int n, m, start;
    static List<Edge>[] g;
    static List<Edge>[] rg;

    static int[] dist;
    static int[] rdist;

    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    static void dijkstra(List<Edge>[] graph, int[] d, int start) {
        d[start] = 0;
        pq.offer(new Edge(start, 0));
        while(!pq.isEmpty()) {
            Edge cur = pq.poll();
            int cv = cur.v;
            int cc = cur.cost;
            if(d[cv] < cc) continue;

            for(Edge e : graph[cv]) {
                int nv = e.v;
                int nc = e.cost;
                if(d[nv] > d[cv] + nc) {
                    d[nv] = d[cv] + nc;
                    pq.offer(new Edge(nv, d[nv]));
                }
            }
        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        /*
        필요한거 : start -> everywhere 거리 (1)
                 everywhere -> start 거리  (2)
        (1)은 start에서 다익 돌리면 됨
        (2)는 플로이드 워셜 or 다익 N번인데, 이는 시간초과

        따라서 주어진 방향그래프의 간선을 전부 뒤집어서 연결하여 얻은 방향그래프 rg에 대하여
        start에서 다익 (거꾸로 만든 그래프의 start -> everywhere  =>  원래 그래프에서 everywhere -> start)
        
        
        오고 간다 : 온 거리 + 간 거리
        첨엔 온 거리, 간 거리 각각중에 최대 구하는 건줄
         */

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        g = new List[n + 1];
        rg = new List[n + 1];
        dist = new int[n + 1];
        rdist = new int[n + 1];
        for(int i = 0 ; i < n + 1 ; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
            rdist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            g[a].add(new Edge(b, c));
            rg[b].add(new Edge(a, c));
        }

        dijkstra(g, dist, start);
        dijkstra(rg, rdist, start);

//        System.out.println(Arrays.toString(dist));
//        System.out.println(Arrays.toString(rdist));

        int max = -1;
        for(int i = 1 ; i < n + 1 ; i++) {
            if(max < dist[i] + rdist[i]) max = dist[i] + rdist[i];
        }
        System.out.println(max);
    }
}