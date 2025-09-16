import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        boolean end;
        HashMap<Integer, Node> child;

        public Node() {
            end = false;
            this.child = new HashMap<>();
        }
    }

    static void insert(String s) {
        Node curr = root;
        int len = s.length();
        for(int i = 0 ; i < len ; i++) {
            int key = s.charAt(i) - 'a';
            if(curr.child.containsKey(key)) {
                curr = curr.child.get(key);
            } else {
                Node node = new Node();
                curr.child.put(key, node);
                curr = node;
            }
        }
        curr.end = true;
    }

    static void verify(String s) {
        Node curr = root;
//        int debug = 0;

        int len = s.length();
        for(int i = 0 ; i < len ; i++) {
            int key = s.charAt(i) - 'a';

            Node node = curr.child.get(key);
            //일단 다음칸으로 넘어감
            //이전칸의 자식노드가 여러개거나, 첫글자거나, 마지막이거나 -> 타이핑 해야하는 경우
            if(i == 0 || curr.child.size() > 1 || curr.end) {
                cnt++;
//                debug++;
            }
            if(node != null) {
                curr = node;
            }

        }
//        System.out.println(s + " typed : " + debug);
    }

    static Node root;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if(s == null || s.isEmpty()) {
                sb.setLength(sb.length() - 1);
                System.out.print(sb);
                return;
            }

            int n = Integer.parseInt(s);
            String[] ipts = new String[n];

            cnt = 0;
            root = new Node();
            for(int i = 0 ; i < n ; i++) {
                ipts[i] = br.readLine();
                insert(ipts[i]);
            }
            for(int i = 0 ; i < n ; i++) {
                verify(ipts[i]);
            }
//            System.out.println("cnt : " + cnt);
//            System.out.println((double)cnt / ipts.length);
            double d = (double)cnt / ipts.length;
            sb.append(String.format("%.2f", d)).append("\n");
        }
    }
}
