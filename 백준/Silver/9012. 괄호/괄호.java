import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            boolean flag = true;
            Stack<Character> s = new Stack<>();
            String ipt = br.readLine();
            for(int j = 0 ; j < ipt.length() ; j++) {
                if(ipt.charAt(j) == '(') {
                    s.push(ipt.charAt(j));
                } else {
                    if(s.isEmpty()) {
                        bw.write("NO\n");
                        flag = false;
                        break;
                    } else {
                        s.pop();
                    }
                }
            }
            if(flag) {
                if(s.isEmpty()) bw.write("YES\n");
                else bw.write("NO\n");
            }

        }
        bw.flush();
        bw.close();
    }
}
