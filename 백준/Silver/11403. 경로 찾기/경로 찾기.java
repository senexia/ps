import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> l = new ArrayList<>();
    static boolean[] v;
    static boolean[] memo;
    static void dfs(int x) {
//        v[x] = true;
        List<Integer> temp = l.get(x);
        for(int nd : temp) {
            if(!v[nd]) {
                v[nd] = true;
                memo[nd] = true;
                dfs(nd);
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        v = new boolean[n + 1];
        memo = new boolean[n + 1];
        for(int i = 0 ; i <= n ; i++) l.add(new ArrayList<>());

        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s, " ");
            for(int j = 0 ; j < n ; j++) {
                int tok = Integer.parseInt(st.nextToken());
                if(tok == 1) {
                    l.get(i+1).add(j+1);
                }
            }
        }
        //System.out.println(l);

        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= n ; i++) {
            dfs(i);
            for(int j = 1 ; j <= n ; j++) {
                sb.append(memo[j] ? "1 " : "0 ");
            }
            sb.append("\n");
            Arrays.fill(v, false);
            Arrays.fill(memo, false);
        }
        System.out.println(sb);
    }
}