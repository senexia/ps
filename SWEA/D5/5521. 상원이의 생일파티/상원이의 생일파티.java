import java.io.*;
import java.util.*;
 
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> g;
        int tc = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> q = new ArrayDeque<>();
 
        for(int t = 1 ; t <= tc ; t++) {
            int cnt = 0;
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
 
            g = new ArrayList<>();
            boolean[] v = new boolean[n + 1];
            for(int i = 0 ; i < n + 1 ; i++) g.add(new ArrayList<>());
            for(int i = 0 ; i < m ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                g.get(a).add(b);
                g.get(b).add(a);
            }
            q.offer(new int[] {1, 0});
            v[1] = true;
            while(!q.isEmpty()) {
                int[] temp = q.poll();
//                System.out.println(Arrays.toString(temp));
                int curr = temp[0];
                int depth = temp[1];
                if(depth > 2) break;
 
                for(int i : g.get(curr)) {
                    if(v[i]) continue;
                    v[i] = true;
                    if(depth < 2) {
                        cnt++;
//                        System.out.println(i);
                    }
                    q.offer(new int[] {i, depth + 1});
                }
            }
            sb.append(cnt).append("\n");
            q.clear();
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}