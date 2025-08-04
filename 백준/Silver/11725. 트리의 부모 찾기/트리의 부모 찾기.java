import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] v;
        int[] parents;

        List<List<Integer>> tree = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        v = new boolean[n + 1];
        parents = new int[n + 1];

        for(int i = 0 ; i <= n ; i++) {
            tree.add(new ArrayList<>());
        }

        for(int i = 0 ; i < n - 1 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        //루트에서 리프방향으로 BFS
        q.offer(1);
        v[1] = true;
        while(!q.isEmpty()) {
            int curr = q.poll();
            List<Integer> subtree = tree.get(curr);
            for(int next : subtree) {
                if(!v[next]) {
                    v[next] = true;
                    parents[next] = curr;
                    q.offer(next);
                }
            }
        }


        for(int i = 2 ; i <= n ; i++) {
            sb.append(parents[i]).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}