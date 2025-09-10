import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> q = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String query = st.nextToken();
            if(query.equals("push_back")) {
                q.offerLast(Integer.parseInt(st.nextToken()));
            } else if(query.equals("push_front")) {
                q.offerFirst(Integer.parseInt(st.nextToken()));
            } else if(query.equals("front")) {
                if(q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(q.peekFirst()).append("\n");
                }
            } else if(query.equals("back")) {
                if(q.isEmpty()) {
                    sb.append("-1\n");
                } else {
                    sb.append(q.peekLast()).append("\n");
                }
            } else if(query.equals("empty")) {
                sb.append(q.size() == 0 ? "1\n" : "0\n");
            } else if(query.equals("size")) {
                sb.append(q.size()).append("\n");
            } else if(query.equals("pop_front")) {
                sb.append(q.size() == 0 ? "-1\n" : q.pollFirst() + "\n");
            } else {
                sb.append(q.size() == 0 ? "-1\n" : q.pollLast() + "\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}