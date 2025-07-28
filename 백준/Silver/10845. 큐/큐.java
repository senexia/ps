import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new ArrayDeque<>();
        int cnt = Integer.parseInt(br.readLine());

        String[] ipt;
        int last = 0;
        for(int i = 0 ; i < cnt ; i++) {
            ipt = br.readLine().split(" ");
            if(ipt[0].equals("push")) {
                q.offer(Integer.parseInt(ipt[1]));
                last = Integer.parseInt(ipt[1]);
            }
            if(ipt[0].equals("pop")) {
                if(!q.isEmpty()) {
                    bw.write(String.valueOf(q.poll()) + "\n");
                } else {
                    bw.write("-1\n");
                }
            }
            if(ipt[0].equals("size")) {
                bw.write(String.valueOf(q.size()) + "\n");
            }
            if(ipt[0].equals("empty")) {
                if(!q.isEmpty()) bw.write("0\n");
                else bw.write("1\n");
            }
            if(ipt[0].equals("front")) {
                if(!q.isEmpty()) bw.write(String.valueOf(q.peek()) + "\n");
                else bw.write("-1\n");
            }
            if(ipt[0].equals("back")) {
                if(!q.isEmpty()) bw.write(String.valueOf(last) + "\n");
                else bw.write("-1\n");
            }
        }




        bw.flush();
        bw.close();
    }
}
