import java.io.*;
import java.util.*;

public class Main {
    static class Serial {
        String value;
        int len;
        int digitsum;
        public Serial(String s) {
            this.value = s;
            this.len = s.length();
            int sum = 0;
            for(int i = 0 ; i < len ; i++) {
                char c = s.charAt(i);
                if(c >= '0' && c <= '9') {
                   sum += (c - '0');
                }
            }
            this.digitsum = sum;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Serial> pq = new PriorityQueue<>((o1, o2) ->
        {
            if(o1.len != o2.len) return o1.len - o2.len;
            else {
                if(o1.digitsum != o2.digitsum) return o1.digitsum - o2.digitsum;
                else return o1.value.compareTo(o2.value);
            }
        });

        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n ; i++) {
            pq.offer(new Serial(br.readLine()));
        }

        while(!pq.isEmpty()) sb.append(pq.poll().value).append("\n");
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}