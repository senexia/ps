import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        PriorityQueue<Long> q = new PriorityQueue<>();

        for(int i = 0 ; i < tc ; i++) {
            q.offer(Long.parseLong(br.readLine()));
        }
        long sum = 0;

        while(q.size() > 1) {
            long temp = q.poll() + q.poll();
            sum += temp;
            q.offer(temp);
        }
        bw.write(String.valueOf(sum));


        bw.flush();
        bw.close();
    }
}