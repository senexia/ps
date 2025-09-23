import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] leftdepth;
    static boolean[] v;
    static List<List<Integer>> g;

    static int n, d, s;
    static int cnt = 0;

    static void leaftoroot(int x) {
        int dist = 0;
        while(x != 0) {
//            leftdepth[x] = Math.max(leftdepth[x], dist++);
//            x = parent[x];
//            if(x == 0) return;
            //한 경로 아래에 여러 리프가 있으면 중복 탐색이 많아져서 시간초과 뜨는듯
            //애초에 리프를 depth 기준으로 pq에 담아서 깊이가 큰거부터 타고 올라가면
            //이후에 탐색되는 것들은 중복이 발생하더라도 if조건에서 가지치기가 자동으로 됨
            //  >=가 좀 더 강한데 대신 배열 초깃값이랑 dist 둘 다 0이라 바로 걸림
            //  >=를 쓸거면 배열을 다 -1로 초기화해둬야 할 듯
            if(leftdepth[x] >= dist) return;

            leftdepth[x] = dist++;
            x = parent[x];
        }
    }

    static void dfs(int x) {
//        System.out.println("1. Current : " + x + ", cnt : " + cnt);



        if(leftdepth[x] <= d) {
            // ==d를 하면 루트에서 시작해서 더이상 방문 안 해도 되는 경우를 처리 못함
            // 따라서 <=d로 주고, x가 루트가 아니면 되돌아가는거 +1하고 리턴
            if(x != s) cnt++;
//            System.out.println("2. Current : " + x + ", cnt : " + cnt);
            return;
        }

        for(int next : g.get(x)) {
            if(!v[next] && leftdepth[next] >= d) {
                v[next] = true;
                cnt++;
                dfs(next);
            }
        }
        
        if(x != s) cnt++;
        //돌아갈때 +1되는거. 루트는 돌아갈곳이 없으니 제외
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<int[]> leafq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        ArrayDeque<int[]> q = new ArrayDeque<>();

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        if(n == 1) {
            //항상 n 가장작을때 확인
            System.out.println(0);
            return;
        }
        
        /*
        접근 1. dfs로 한 칸 전진할때마다 cnt에 +1, 리프에 도달하면 cnt에서 d를 빼준뒤 전체 2배
        근데 이러면 예시의 2번 노드같은 분기점이 걸쳐있을 때 처리가 상당히 애매해짐

        접근 2. 루트가 어디인지는 s가 주어지므로 알 수 있따 따라서 루트에서 bfs를 한번 돌리면서
        - 각 노드에 대해 해당 노드의 부모 노드 정보 저장
        - 리프노드 전부 파악

        이후 모든 리프노드에 대해 부모노드만 타고 올라가면서 루트노드까지 올라감
        이 과정에서 모든 노드에 대해 '리프까지 남은 최대길이' 저장
        '최대'길이 인 이유는 2번노드처럼 갈림길이 있을 수 있기 때문

        마지막으로 루트에서 dfs.
        1칸 전진할때마다 cnt에 +1
        현재 칸의 '리프까지 남은 최대길이' == d라면 더이상 탐색 안해도 되므로 return
        이때 return 전에도 cnt에 +1
        왜? 되돌아갈때도 거리가 증가하니까
         */

        g = new ArrayList<>();
        for(int i = 0 ; i < n + 1 ; i++) g.add(new ArrayList<>());
        parent = new int[n + 1];
        leftdepth = new int[n + 1];
        v = new boolean[n + 1];

        for(int i = 0 ; i < n - 1 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g.get(a).add(b);
            g.get(b).add(a);
        }

        //리프 싹다찾기
        v[s] = true;
        q.offer(new int[] {s, 0});
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int curr = temp[0];
            int depth = temp[1];

            int child = 0; //큐에 넣을때마다 증가.
            // 리스트 다 봤는데 큐에 들어간게 하나도 없어서 child가 여전히 0이면 리프

            for(int next : g.get(curr)) {
                if(!v[next]) {
                    v[next] = true;
                    parent[next] = curr;
                    child++;
                    q.offer(new int[] {next, depth + 1});
                }
            }
            if(child == 0) leafq.offer(new int[] {curr, depth});
        }

        Arrays.fill(leftdepth, -1);
        //모든 리프에서 루트로 가면서 최대 남은 길이 갱신
        while(!leafq.isEmpty()) {
            leaftoroot(leafq.poll()[0]);
        }
//        System.out.println(Arrays.toString(leftdepth));


        Arrays.fill(v, false);
        v[s] = true;
        dfs(s);
        System.out.println(cnt);
    }
}
