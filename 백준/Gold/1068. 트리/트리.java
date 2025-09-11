import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        boolean isRoot;
        ArrayList<Node> child;
        public Node() {
            this.isRoot = false;
            child = new ArrayList<>();
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] parent = new int[n];
        HashMap<Integer, Node> tree = new HashMap<>();
        ArrayDeque<Node> q = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++) {
            tree.put(i, new Node());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            int par = Integer.parseInt(st.nextToken());
            parent[i] = par;
            if(par == -1) {
                tree.get(i).isRoot = true;
                continue;
            }
            tree.get(par).child.add(tree.get(i));
        }

        //일단 리프 개수 세고
        int leafs = 0;
        for(int i = 0 ; i < n ; i++) {
            if(tree.get(i).child.isEmpty()) {
                leafs++;
            }
        }

        //루트 지우면 그냥 0
        int del = Integer.parseInt(br.readLine());
        if(tree.get(del).isRoot) {
            System.out.println(0);
            return;
        }

        //삭제 노드 아래에 있는 리프 노드 세서 빼기
        //삭제하려는 노드를 지운 뒤 이 노드의 부모노드가 리프가 되는 경우가 있을 수 있음
        //
        int cnt = 0;
        q.offer(tree.get(del));
        while(!q.isEmpty()) {
            Node node = q.poll();

            if(node.child.isEmpty()) {
                cnt++;
            } else {
                for(Node c : node.child) {
                    if(c.child.isEmpty()) {
                        cnt++;
                        continue;
                    }
                    q.offer(c);
                }
            }
        }
        //삭제 대상 노드를 지웠을 때 부모노드가 루트가 되는 경우
        if(tree.get(parent[del]).child.size() == 1) cnt--;
        System.out.println(leafs - cnt);

    }
}