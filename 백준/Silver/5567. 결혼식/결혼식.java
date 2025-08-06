import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> li = new ArrayList<>();
    static int cnt = 0;
    static boolean[] v;
    static void bfs(int start) {
        Queue<int[]> q = new ArrayDeque<>();
        v[start] = true;
        q.offer(new int[] {start, 0});

        while(!q.isEmpty()) {
            int[] temp = q.poll();

            int idx = temp[0];
            int dep = temp[1];
            if(dep >= 2) continue;

            List<Integer> friends = li.get(idx);
            for(int ppl : friends) {
                if(!v[ppl]) {
                    v[ppl] = true;
                    cnt++;
                    q.offer(new int[] {ppl, dep + 1});
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        v = new boolean[n + 1];
        for(int i = 0 ; i < n + 1 ; i++) li.add(new ArrayList<>());
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            li.get(a).add(b);
            li.get(b).add(a);
        }

        bfs(1);
        System.out.println(cnt);
    }
}