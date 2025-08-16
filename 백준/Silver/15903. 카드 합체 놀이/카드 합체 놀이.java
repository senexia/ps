import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < a ; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }
        for(int i = 0 ; i < b ; i++) {
            long x = pq.poll();
            long y = pq.poll();
            pq.offer(x + y);
            pq.offer(x + y);
        }
        long sum = 0;
        while(!pq.isEmpty()) {
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}