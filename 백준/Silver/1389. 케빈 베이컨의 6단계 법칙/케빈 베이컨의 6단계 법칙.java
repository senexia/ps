import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static List<List<Integer>> g = new ArrayList<>();
    static boolean[] v;
    static int[] bacon;

    static int sum() {
        int ret = 0;
        for(int i = 1 ; i < n + 1 ; i++) {
            ret += bacon[i];
        }
        return ret;
    }

    static void bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        v[x] = true;
        bacon[x] = 0;
        q.offer(x);
        while(!q.isEmpty()) {
            int temp = q.poll();
            for(int num : g.get(temp)) {
                if(!v[num]) {
                    v[num] = true;
                    bacon[num] = bacon[temp] + 1;
                    q.offer(num);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        v = new boolean[n + 1];
        bacon = new int[n + 1];

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

        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 1 ; i < n + 1 ; i++) {
            bfs(i);
            if(min > sum()) {
                min = sum();
                idx = i;
            }
            Arrays.fill(v, false);
            Arrays.fill(bacon, 0);
        }
        System.out.println(idx);
    }
}