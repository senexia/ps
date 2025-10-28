import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<List<Integer>> g;
    static int[] sem;
    static boolean[] v;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();

    static void dfs(int x) {
        for(int i : g.get(x)) {
            if(v[i]) continue;

            v[i] = true;
            dfs(i);
        }
        stack.push(x);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        g = new ArrayList<>();
        for(int i = 0 ; i < n + 1 ; i++) g.add(new ArrayList<>());
        v = new boolean[n + 1];

        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
        }

        //일단 위상정렬 시켜놓고
        for(int i = 1 ; i < n + 1 ; i++) {
            if(v[i]) continue;

            v[i] = true;
            dfs(i);
        }


        //맨 처음에는 첫노드부터 빼면서 bfs를 생각햇는데 중복이 너무 많아짐
        //직접연결된 간선 외에도 전부 propagate되니까
        //따라서 단순히 sem배열로 직접연결된 경우에 대해서만 dp로 값을 채우면 최소중복
        //이때 depth가 이수할수있는 학기가 됨
        sem = new int[n + 1];
        while(!stack.isEmpty()) {
            int curr = stack.pop();

            if(sem[curr] == 0) sem[curr] = 1;

            for(int next : g.get(curr)) {
                sem[next] = Math.max(sem[next], sem[curr] + 1);
            }
        }


        for(int i = 1 ; i < n + 1 ; i++) {
            sb.append(sem[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}