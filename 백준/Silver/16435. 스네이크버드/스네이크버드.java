import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) pq.offer(Integer.parseInt(st.nextToken()));

        while(!pq.isEmpty() && h >= pq.peek()) {
            pq.poll();
            h++;
        }
        System.out.println(h);
    }
}