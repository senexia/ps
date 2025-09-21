import java.io.*;
import java.util.*;

public class Main {
    static int[] uf;
    static int find(int x) {
        if(x == uf[x]) return x;
        return uf[x] = find(uf[x]);
    }

    static boolean union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if(a == b) return false;
        uf[a] = b;
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        /*
        처음부터 도시 2개를 만들려고 하면 어렵다
        MST의 특징을 생각해보면, 모든 정점이 연결됨과 동시에 간선의 개수가 V - 1개다.
        그 말은, 완성된 MST에서 가중치가 가장 큰 간선 하나를 삭제하면 둘로 나뉘게 된다는 말이고
        곧 문제가 원하는 조건을 만족한다

        즉, 일반적인 MST 생성을 하되 break 조건을 V - 1이 아닌 V - 2로 바꿔주면 될 듯
        이게 가능한 이유는 '마을에는 집이 하나 이상 있어야 한다' 라는 조건때문
        마을에 집이 2개 이상 이랬으면 훨씬 복잡했을텐데
         */
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        if(v == 2) {
            System.out.println(0);
            return;
            //로직은 맞는데 틀린거 보니 아마 이런 최소케이스 처리 안해서 그런 듯
            //항상 n=1이나 n=2같은 최소케이스 신경좀 써라
        }
        
        uf = new int[v + 1];
        for(int i = 0 ; i < v + 1 ; i++) uf[i] = i;
        int[][] g = new int[e][3];

        for(int i = 0 ; i < e ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[i] = new int[] {from, to, c};
        }
        Arrays.sort(g, (o1, o2) -> o1[2] - o2[2]);

        int sum = 0;
        int cnt = 0;
        for(int[] edge : g) {
            int v1 = edge[0];
            int v2 = edge[1];
            if(union(v1, v2)) {
                sum += edge[2];
                cnt++;
            }
            if(cnt == v - 2) break;
        }
        System.out.println(sum);
    }
}