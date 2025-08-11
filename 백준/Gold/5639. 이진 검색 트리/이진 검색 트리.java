import java.io.*;
import java.util.*;

class Node {
    int v;
    Node left;
    Node right;
    public Node(int x) {
        this.v = x;
    }

    public void insert(int x) {
        if(v > x) {
            if(this.left == null) {
                this.left = new Node(x);
            } else {
                this.left.insert(x);
            }
        } else {
            if(this.right == null) {
                this.right = new Node(x);
            } else {
                this.right.insert(x);
            }
        }
    }

    public void postOrder() {
        if(this.left != null) this.left.postOrder();
        if(this.right != null) this.right.postOrder();
        System.out.println(this.v);

    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node(n);
        while(true) {
            String s = br.readLine();
            if(s == null || s.equals("")) break;
            int x = Integer.parseInt(s);
            root.insert(x);
        }
        root.postOrder();
    }
}