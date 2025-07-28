import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            String s = br.readLine();
            if(s.equals("0")) {
                if(pq.size() > 0) {
                    bw.write(String.valueOf(pq.poll()) + "\n");
                } else {
                    bw.write("0\n");
                }
            } else {
                pq.offer(Integer.parseInt(s));
            }
        }
        bw.flush();
        bw.close();
    }
}