import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        String[] op = new String[2];
        for(int i = 0 ; i < cnt ; i++) {
            op = br.readLine().split(" ");
            if(op[0].equals("push")) {
                s.push(Integer.parseInt(op[1]));
            } else if(op[0].equals("top")) {
                if(s.isEmpty()) bw.write(String.valueOf(-1) + "\n");
                else bw.write(String.valueOf(s.peek()) + "\n");
            } else if(op[0].equals("size")) {
                bw.write(String.valueOf(s.size()) + "\n");
            } else if(op[0].equals("empty")) {
                if(s.isEmpty()) bw.write(String.valueOf(1) + "\n");
                else bw.write(String.valueOf(0) + "\n");
            } else { // pop
                if(s.isEmpty()) bw.write(String.valueOf(-1) + "\n");
                else {
                    int n = s.pop();
                    bw.write(String.valueOf(n) + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}