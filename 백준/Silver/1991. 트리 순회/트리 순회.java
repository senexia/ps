import java.io.*;
import java.util.*;
class Node {
    String val;
    Node left;
    Node right;

    public Node(String v) {
        this.val = v;
    }
}



public class Main {
    static StringBuilder sb = new StringBuilder();
    static void preorder(Node n) {
        sb.append(n.val);
        if(n.left != null) preorder(n.left);
        if(n.right != null) preorder(n.right);
    }
    static void inorder(Node n) {
        if(n.left != null) inorder(n.left);
        sb.append(n.val);
        if(n.right != null) inorder(n.right);
    }
    static void postorder(Node n) {
        if(n.left != null) postorder(n.left);
        if(n.right != null) postorder(n.right);
        sb.append(n.val);
    }

    static Node[] nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<String> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        nodes = new Node[n];
        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            Character c = s.charAt(0);
            nodes[c - 'A'] = new Node(c.toString());
            stack.push(s);
        }
        while(!stack.isEmpty()) {
            String s = stack.pop();
            Character root = s.charAt(0);
            Character left = s.charAt(2);
            Character right = s.charAt(4);
            if(!(left == '.')) {
                nodes[root - 'A'].left = nodes[left - 'A'];
            }
            if(!(right == '.')) {
                nodes[root - 'A'].right = nodes[right - 'A'];
            }
        }
        preorder(nodes[0]);
        sb.append("\n");
        inorder(nodes[0]);
        sb.append("\n");
        postorder(nodes[0]);
        sb.append("\n");
        System.out.print(sb);
    }
}