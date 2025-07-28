import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int op = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < op ; i++) {
            int ipt = Integer.parseInt(br.readLine());

            if(ipt == 0) {
                if(pq.size() > 0) {
                    bw.write(String.valueOf(pq.poll()) + "\n");
                } else {
                    bw.write("0\n");
                }
            } else {
                pq.offer(ipt);
            }
        }
        bw.flush();
        bw.close();
    }
}