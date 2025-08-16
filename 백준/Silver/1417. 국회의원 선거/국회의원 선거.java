import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println(0);
            return;
        }
        int cnt = 0;
        int dasom = Integer.parseInt(br.readLine());
        for(int i = 1 ; i < n ; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while(true) {
            int temp = pq.poll();
            if(dasom > temp) break;
            cnt++;
            dasom++;
            pq.offer(--temp);
        }
        System.out.println(cnt);
    }
}