import java.io.*;
import java.util.*;

public class Main {
    static int[] uf;
    static int group;

    static int find(int x) {
        if(x == uf[x]) return x;
        return uf[x] = find(uf[x]);
    }

    static void union(int x, int y) {
        if(find(x) != find(y)) {
            group--;
            uf[find(x)] = find(y);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int total = 0;
        group = n;

        uf = new int[n + 1];
        int[] cost = new int[n + 1];
        for(int i = 1 ; i <= n ; i++) uf[i] = i;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        HashMap<Integer, TreeSet<Integer>> hm = new HashMap<>();
        //      group         cost
        for(int i = 1 ; i <= n ; i++) {
            int key = find(uf[i]);
            hm.putIfAbsent(key, new TreeSet<>());
            hm.get(key).add(cost[i]);
        }

        for(int keys : hm.keySet()) {
            total += hm.get(keys).first();
        }

        System.out.println(total > k ? "Oh no" : total);
    }
}