import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        String s = br.readLine();
        for(int i = 0 ; i < s.length() ; i++) {
            pq.offer(s.charAt(i) - '0');
        }
        while(!pq.isEmpty()) sb.append(pq.poll());
        System.out.println(sb);
    }
}