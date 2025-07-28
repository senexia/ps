import java.util.*;
import java.io.*;

public class Main {
    static boolean[] vb;
    static boolean[] vd;
    static List<List<Integer>> l = new ArrayList<>();
    static StringBuilder sd = new StringBuilder();

    static void bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        vb[x] = true;
        q.offer(x);

        while(!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp + " ");
            List<Integer> al = l.get(temp);
            for(int i : al) {
                if(!vb[i]) {
                    vb[i] = true;
                    q.offer(i);
                }
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
    static void dfs(int x) {
        sd.append(x + " ");
        vd[x] = true;
        List<Integer> al = l.get(x);
        for(int i : al) {
            if(!vd[i]) {
                vd[i] = true;
                dfs(i);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        vb = new boolean[n + 1];
        vd = new boolean[n + 1];

        for(int i = 0 ; i < n + 1 ; i++) l.add(new ArrayList<>());
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            l.get(a).add(b);
            l.get(b).add(a);
        }
        for(List<Integer> li : l) Collections.sort(li);

        dfs(v);

        sd.setLength(sd.length() - 1);
        System.out.println(sd);
        bfs(v);

    }
}