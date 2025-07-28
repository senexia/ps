import java.util.*;
import java.io.*;

public class Main {
    static int cnt = 0;
    static List<List<Integer>> li = new ArrayList<>();
    static boolean[] visited;
    static void dfs(int i) {
        visited[i] = true;
        List<Integer> t = li.get(i);
        for(int j : t) {
            if(!visited[j]) dfs(j);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        for(int i = 0 ; i < n + 1; i++) {
            li.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            li.get(u).add(v);
            li.get(v).add(u);
        }

        for(int i = 1 ; i < n + 1 ; i++) {
            if(!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();

    }
}
