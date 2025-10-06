import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String value;
        TreeMap<String, Node> child;

        public Node(String v) {
            this.value = v;
            this.child = new TreeMap<>();
        }
    }

    static Node root;
    static int depth = 0;
    static StringBuilder sb = new StringBuilder();

    static void insert(String l) {
        Node curr = root;
        String[] ipt = l.split(" ");
        int x = Integer.parseInt(ipt[0]);
        for(int i = 1 ; i < x + 1 ; i++) {
            if(curr.child.containsKey(ipt[i])) {
                curr = curr.child.get(ipt[i]);
            } else {
                Node next = new Node(ipt[i]);
                curr.child.put(ipt[i], next);
                curr = next;
            }
        }
    }
    static void dfs(Node node) {
        for(String key : node.child.keySet()) {
            if(depth == 0) {
                sb.append(node.child.get(key).value).append("\n");
            } else {
                sb.append("--".repeat(depth))
                  .append(node.child.get(key).value)
                  .append("\n");
            }
            depth++;
            dfs(node.child.get(key));
        }
        depth--;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        트라이 느낌으로 가면 될 것 같음
        각 노드의 child를 treemap으로 관리하면 사전순 조건도 자동으로 만족
        */

        root = new Node("");
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            insert(br.readLine());
        }

        dfs(root);

        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }

}