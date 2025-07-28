import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();

        for(int i = 0 ; i < n ; i++) {
            int j = Integer.parseInt(br.readLine());

            if(j == 0) {
                s.pop();
            } else {
                s.push(j);
            }
        }
        int sum = 0;
        while(!s.isEmpty()) {
            sum += s.pop();
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}
