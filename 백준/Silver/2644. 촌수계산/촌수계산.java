
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<List<Integer>> g = new ArrayList<>();
    static int[] depth;
    static boolean[] v;
    static void bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        depth[x] = 0;
        while(!q.isEmpty()) {
            int y = q.poll();
            v[y] = true;
            for(int num : g.get(y)) {
                if(!v[num]) {
                    v[num] = true;
                    depth[num] = depth[y] + 1;
                    q.offer(num);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());
        depth = new int[n + 1];
        v = new boolean[n + 1];
        Arrays.fill(depth, -1);

        int m = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n + 1 ; i++) {
            g.add(new ArrayList<>());
        }
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            g.get(a).add(b);
            g.get(b).add(a);
        }
        bfs(p1);
        System.out.println(depth[p2]);

    }
}