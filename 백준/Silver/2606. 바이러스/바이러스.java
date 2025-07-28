import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> l = new ArrayList<>();
    static boolean[] v;
    static void dfs(int n) {
        if(v[n]) return;
        v[n] = true;
        List<Integer> temp = l.get(n);
        for(int i : temp) {
            dfs(i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int nodes = Integer.parseInt(br.readLine());
        int ip = Integer.parseInt(br.readLine());
        v = new boolean[nodes + 1];
        for(int i = 0 ; i <= nodes ; i++) {
            l.add(new ArrayList<>());
        }
        StringTokenizer st;
        for(int i = 0 ; i < ip ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            l.get(a).add(b);
            l.get(b).add(a);
        }
        dfs(1);
        int cnt = 0;
        for(int i = 1 ; i < nodes + 1 ; i++) {
            if(v[i]) cnt++;
        }
        bw.write(String.valueOf(cnt - 1));
        //1번으로부터 감염 -> 1번 1개 제외
        bw.flush();
        bw.close();
    }
}