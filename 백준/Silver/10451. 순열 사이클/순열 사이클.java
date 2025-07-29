
import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> g;
    static boolean[] v;

    static void dfs(int x) {
        List<Integer> temp = g.get(x);
        v[x] = true;
        for(int next : temp) {
            if(!v[next]) {
                dfs(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < tc ; i++) {
            g = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            int comp = 0;
            v = new boolean[n + 1];

            for(int j = 0 ; j <= n ; j++) g.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < n ; j++) {
                g.get(j+1).add(Integer.parseInt(st.nextToken()));
            }

            for(int j = 1 ; j <= n ; j++) {
                if(!v[j]) {
                    comp++;
                    dfs(j);
                }
            }
            sb.append(comp).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}