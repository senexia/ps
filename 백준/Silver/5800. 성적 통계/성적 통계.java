import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int t = Integer.parseInt(br.readLine());
        for(int tt = 1 ; tt <= t ; tt++) {
            sb.append("Class ").append(tt).append("\n");
            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            for(int i = 0 ; i < n ; i++) {
                pq.offer(Integer.parseInt(st.nextToken()));
            }
            int max = pq.peek();
            int prev = pq.poll();
            int maxgap = -1;
            for(int i = 0 ; i < n - 1 ; i++) {
                int curr = pq.poll();
                if(maxgap < Math.abs(prev - curr)) {
                    maxgap = Math.abs(prev - curr);
                }
                prev = curr;
            }
            sb.append("Max ").append(max).append(", Min ").append(prev).append(", Largest gap ").append(maxgap).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}