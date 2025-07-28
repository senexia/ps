import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        for(int i = 1 ; i <= n ; i++) {
            q.addLast(i);
        }

        while(true) {
            if(q.size() == 1) {
                break;
            }
            q.pollFirst();
            if(q.size() == 1) {
                break;
            }
            q.addLast(q.pollFirst());
        }
        bw.write(String.valueOf(q.peek()));
        bw.flush();
        bw.close();
    }
}
