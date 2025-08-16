import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int centi = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        boolean flag = false;
        for(int i = 0 ; i < limit ; i++) {
            if(centi > pq.peek()) {
                flag = true;
                break;
            }
            pq.offer((int)Math.max(1, Math.floor(pq.poll()/2)));
            cnt++;

        }
        if(centi > pq.peek()) flag = true;
        if(flag) sb.append("YES\n").append(cnt);
        else sb.append("NO\n").append(pq.peek());
        System.out.println(sb);


    }
}