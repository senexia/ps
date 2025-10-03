import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String text;
        Node prev;
        Node next;

        public Node(String t, Node p, Node n) {
            this.text = t;
            this.prev = p;
            this.next = n;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        /*
        b형스럽다
        리스트를 써서 삽입, 삭제를 하면 O(n)이므로 시간초과를 절대로 피할 수 없음
        커서 위치를 ptr로 관리하고 양방향 어레이리스트를 직접 구현해야 할듯

        이후 모든 연산 마쳣다면 맨앞부터 돌면서 결과문자열 조회
        그러면 O(노드수 + 연산수)에 가능
         */

        Node start = new Node("", null, null);
        Node curr = null;
        Node prev = start;
        //초기단어 세팅
        for(int i = 0 ; i < s.length() ; i++) {
            curr = new Node(String.valueOf(s.charAt(i)), prev, null);
            prev.next = curr;
            prev = curr;
        }


        //쿼리
        for(int i = 0 ; i < n ; i++) {
            String[] ipt = br.readLine().split(" ");
            if(ipt[0].equals("L")) {
                if(curr.prev == null) continue;
                curr = curr.prev;
            } else if(ipt[0].equals("D")) {
                if(curr.next == null) continue;
                curr = curr.next;
            } else if(ipt[0].equals("B")) {
                if(curr.prev == null) continue;
                curr.prev.next = curr.next;
                if(curr.next != null) curr.next.prev = curr.prev;
                curr = curr.prev;
            } else {
                Node node = new Node(ipt[1], curr, curr.next);
                if(curr.next != null) curr.next.prev = node;
                curr.next = node;
                curr = node;
            }
        }



        //출력
        curr = start;
        while(true) {
            sb.append(curr.text);
            if(curr.next == null) break;

            curr = curr.next;
        }
        System.out.print(sb);
    }

}