import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] order;
    static boolean[] visited;
    static List<List<Integer>> g = new ArrayList<>();

    static void bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        int idx = 1;
        order[x] = idx;
        visited[x] = true;
        q.offer(x);
        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next : g.get(curr)) {
                if(!visited[next]) {
                    idx++;
                    visited[next] = true;
                    order[next] = idx;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        order = new int[n + 1];
        visited = new boolean[n + 1];

        for(int i = 0 ; i <= n ; i++) {
            g.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            g.get(u).add(v);
            g.get(v).add(u);
        }
        for(List<Integer> l : g) Collections.sort(l);
        bfs(r);

        for(int i = 1 ; i < n + 1 ; i++) {
            System.out.println(order[i]);
        }


    }
}