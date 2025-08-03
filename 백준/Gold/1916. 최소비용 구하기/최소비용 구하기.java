import java.io.*;
import java.util.*;
class Edge implements Comparable<Edge>{
    public int v;
    public int cost;

    public Edge(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.cost, o.cost);
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<Edge>[] list = new ArrayList[n + 1];
        int[] dist = new int[n + 1];
        boolean[] v = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 0 ; i < n + 1 ; i++) {
            list[i] = new ArrayList<Edge>();
            dist[i] = 999999999;
        }
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        pq.offer(new Edge(from, 0));
        dist[from] = 0;
        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            int cv = curr.v;
            if(v[cv]) continue;

            v[cv] = true;
            for(int i = 0 ; i < list[cv].size() ; i++) {
                Edge temp = list[cv].get(i);
                int next = temp.v;
                int cost = temp.cost;

                if(dist[next] > dist[cv] + cost) {
                    dist[next] = dist[cv] + cost;
                    pq.add(new Edge(next, dist[next]));
                }
            }
        }
        System.out.println(dist[to]);

    }
}