import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int c;
    int v;
    public Edge(int v, int c) {
        this.c = c;
        this.v = v;
    }

    @Override
    public int compareTo(Edge e) {
        return Integer.compare(this.c, e.c);
    }
}

public class Main {
    static int[] dist;
    static int[] val;
    static List<List<Edge>> g;
    static void dijkstra(int s) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.offer(new Edge(s, 0));

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            int cc = curr.c;
            int cv = curr.v;
            if(dist[cv] < cc) continue;

            for(Edge e : g.get(cv)) {
                int nc = e.c;
                int nv = e.v;
                if(dist[nv] > dist[cv] + nc) {
                    dist[nv] = dist[cv] + nc;
                    pq.offer(new Edge(nv, dist[nv]));
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        g = new ArrayList<>();
        for(int i = 0 ; i < n + 1 ; i++) g.add(new ArrayList<>());
        dist = new int[n + 1];
        val = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i < n + 1 ; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < r ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            g.get(a).add(new Edge(b, c));
            g.get(b).add(new Edge(a, c));
        }

        int max = 0;
        for(int i = 1 ; i < n + 1 ; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijkstra(i);

//            System.out.println("Start : " + i);
//            System.out.println("dist : " + Arrays.toString(dist));
//            System.out.println("val : " + Arrays.toString(val));

            int sum = 0;
            for(int j = 1 ; j < n + 1 ; j++) {
                //등호안붙였다고 틀림 에반데
                if(dist[j] <= m) {
                    sum += val[j];
                }
            }
            if(max < sum) max = sum;
        }
        System.out.println(max);
    }
}