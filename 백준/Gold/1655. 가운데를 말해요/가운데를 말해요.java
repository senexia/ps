import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> leftpq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightpq = new PriorityQueue<>();

        boolean isFirst = true;
        int curr = 0; //현재 중앙값
        int len = 0;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            if(isFirst) {
                curr = Integer.parseInt(br.readLine());
                isFirst = false;
                sb.append(curr).append("\n");
                len++;
                continue;
            }

            int next = Integer.parseInt(br.readLine());

            if(len % 2 == 0) {
                if(curr >= next) {
                    leftpq.offer(next);
                } else if(curr < next) {
                    leftpq.offer(curr);
                    rightpq.offer(next);
                    curr = rightpq.poll();
                }
            } else {
                if(curr >= next) {
                    rightpq.offer(curr);
                    leftpq.offer(next);
                    curr = leftpq.poll();
                } else if(curr < next) {
                    rightpq.offer(next);
                }
            }
            len++;
            sb.append(curr).append("\n");
        }
        System.out.print(sb);
    }
}