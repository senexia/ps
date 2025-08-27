import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int v;
    long c;
    public Edge(int v, long c) {
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
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        //100000 * 100000
        int[] path = new int[n + 1];
        long[] dist = new long[n + 1];
        List<List<Edge>> g = new ArrayList<>();
        for(int i = 0 ; i < n + 1 ; i++) {
            g.add(new ArrayList<>());
            dist[i] = Long.MAX_VALUE;
        }

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            g.get(a).add(new Edge(b, c));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist[start] = 0;
        pq.offer(new Edge(start, 0));
        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            long cc = curr.c;
            int cv = curr.v;
            if(cv == end) break;
            if(dist[cv] < cc) continue;

            for(Edge next : g.get(cv)) {
                int nv = next.v;
                long nc = next.c;
                if(dist[nv] > dist[cv] + nc) {
                    dist[nv] = dist[cv] + nc;
                    pq.offer(new Edge(nv, dist[nv]));
                    path[nv] = cv;
                }
            }
        }
//        System.out.println(dist[end]);
//        System.out.println(Arrays.toString(path));
        ArrayDeque<Integer> ps = new ArrayDeque<>();
        StringBuilder p = new StringBuilder();
        int s = end;
//        int cnt = 0;
        while(!(s == 0)) {
            ps.push(s);
            s = path[s];
//            cnt++;
        }
        sb.append(dist[end]).append("\n").append(ps.size()).append("\n");
        while(!ps.isEmpty()) {
            sb.append(ps.pop()).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}