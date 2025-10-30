import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> hs = new HashSet<>();

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0 ; i < 3 ; i++) pq.offer(Integer.parseInt(st.nextToken()));

            int l1 = pq.poll();
            int l2 = pq.poll();
            int l3 = pq.poll();

            if(l1 == 0) break;
            if(l3 >= l1 + l2) {
                sb.append("Invalid\n");
                continue;
            }

            hs.add(l1);
            hs.add(l2);
            hs.add(l3);
            int size = hs.size();

            if(size == 1) sb.append("Equilateral\n");
            else if(size == 2) sb.append("Isosceles\n");
            else sb.append("Scalene\n");
            hs.clear();

        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}