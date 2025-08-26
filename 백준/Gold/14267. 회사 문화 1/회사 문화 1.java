import java.io.*;
import java.util.*;


class Node {
    int id;
    int val;
    ArrayList<Node> list;
    public Node(int id, int val) {
        this.id = id;
        this.val = val;
        this.list = new ArrayList<>();
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //초기화
        Node[] node = new Node[n + 1];
        int[] val = new int[n + 1];
        boolean[] v = new boolean[n + 1];
        ArrayDeque<int[]> q = new ArrayDeque<>();

        for(int i = 1 ; i < n + 1 ; i++) {
            node[i] = new Node(i, 0);
        }

        //자식 설정
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i < n + 1 ; i++) {
            int tok = Integer.parseInt(st.nextToken());
            if(tok == -1) continue;

            node[tok].list.add(node[i]);
        }

        //칭찬
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            node[a].val += b;
        }

        q.offer(new int[] {1, node[1].val});
        v[1] = true;
        val[1] = node[1].val;
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int curr = temp[0];
            int add = temp[1];

            for(Node next : node[curr].list) {
                if(!v[next.id]) {
                    v[next.id] = true;
                    val[next.id] = next.val + add;
                    q.offer(new int[] {next.id, val[next.id]});
                }
            }
        }
        for(int i = 1 ; i < n + 1 ; i++) {
            sb.append(val[i]).append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}