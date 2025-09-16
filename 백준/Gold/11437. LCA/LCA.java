import java.io.*;
import java.util.*;

class Main {
    static int v;
    static ArrayList<ArrayList<Integer>> t;
    static int m;
    static int[] depth;
    static int[] parent;
    static void dfs(int start, int cnt) {
        depth[start] = cnt++;
        for(Integer next: t.get(start)) {
            if(depth[next] == 0) {
                dfs(next, cnt);
                parent[next] = start;
            }
        }
    }


    static int lca(int a, int da, int b, int db){
        if(da > db){
            while(da != db){
                da--;
                a = parent[a];
            }
        }
        else if(da < db){
            while(da != db){
                db--;
                b = parent[b];
            }
        }

        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        v = Integer.parseInt(br.readLine());
        t = new ArrayList<>();

        for(int i = 0 ; i < v + 1 ; i++) t.add(new ArrayList<>());
        for(int i = 0 ; i < v - 1 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            t.get(a).add(b);
            t.get(b).add(a);
        }

        depth = new int[v + 1];
        parent = new int[v + 1];
        m = Integer.parseInt(br.readLine());

        //dfs(1, 0);
        dfs(1, 1);
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int same = lca(a, depth[a], b, depth[b]);
            sb.append(same).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }




}