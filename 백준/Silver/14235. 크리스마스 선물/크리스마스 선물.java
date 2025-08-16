import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            if(s.charAt(0) == '0') {
                if(pq.isEmpty()) sb.append("-1\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                StringTokenizer st = new StringTokenizer(s, " ");
                int m = Integer.parseInt(st.nextToken());
                for(int j = 0 ; j < m ; j++) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }
        System.out.print(sb);
    }
}