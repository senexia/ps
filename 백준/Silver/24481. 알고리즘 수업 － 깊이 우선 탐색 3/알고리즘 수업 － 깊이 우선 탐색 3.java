import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> li = new ArrayList<>();
    static int[] depth;
    static boolean[] visited;

    static void dfs(int x) {
        visited[x] = true;
        for(int num : li.get(x)) {
            if(!visited[num]) {
                if(depth[num] == -1) depth[num] = depth[x] + 1;
                dfs(num);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        depth = new int[n + 1];
        visited = new boolean[n + 1];
        for(int i = 0; i <= n ; i++) li.add(new ArrayList<>());

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u1 = Integer.parseInt(st.nextToken());
            int u2 = Integer.parseInt(st.nextToken());

            li.get(u1).add(u2);
            li.get(u2).add(u1);
        }
        for(List<Integer> l : li) Collections.sort(l);
        Arrays.fill(depth, -1);
        depth[v] = 0;
        dfs(v);

        for(int j = 1 ; j <= n ; j++) {
            System.out.println(depth[j]);
        }
    }
}