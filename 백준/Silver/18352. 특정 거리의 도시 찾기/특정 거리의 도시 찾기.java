import java.io.*;
import java.util.*;


public class Main {
    static int n, m, target;
    static List<List<Integer>> li = new ArrayList<>();
    static int[] dist;
    static boolean[] v;
    static TreeSet<Integer> ts = new TreeSet<>();
    static StringBuilder sb = new StringBuilder();
    static void bfs(int x) {
        v[x] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> temp = li.get(curr);
            for(int next : temp) {
                if(!v[next]) {
                    v[next] = true;
                    dist[next] = dist[curr] + 1;
                    q.offer(next);
                    if(dist[next] == target) {
                        ts.add(next);
                    }
                }
            }
        }

    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        int from = Integer.parseInt(st.nextToken());
        dist = new int[n + 1];
        v = new boolean[n + 1];

        for(int i = 0 ; i <= n ; i++) {
            li.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            li.get(a).add(b);
        }
        dist[from] = 0;
        bfs(from);
        if(ts.size() == 0) {
            System.out.println(-1);
            return;
        } else {
            while(!ts.isEmpty()) {
                sb.append(ts.first()).append("\n");
                ts.remove(ts.first());
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}