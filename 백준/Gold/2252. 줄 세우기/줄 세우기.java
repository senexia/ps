import java.io.*;
import java.util.*;

public class Main {
    static int v, e;
    static List<Integer>[] g;
    static int[] indegree;
    static StringBuilder sb = new StringBuilder();

    static void bfs() {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 1 ; i < v + 1 ; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()) {
            int i = q.poll();
            sb.append(i).append(" ");
            for(int j : g[i]) {
                indegree[j]--;
                if(indegree[j] == 0) {
                    q.offer(j);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        g = new List[v + 1];
        for(int i = 0 ; i < v + 1 ; i++) {
            g[i] = new ArrayList<>();
        }
        indegree = new int[v + 1];
        for(int i = 0 ; i < e ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a -> b
            g[a].add(b);
            indegree[b]++;
        }
        bfs();
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}