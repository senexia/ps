import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); br.readLine();
        String s = br.readLine();
        String target = "IO".repeat(n) + "I";
        int cnt = 0;
        int block = 0;

        for(int i = 1 ; i < s.length() - 1 ; i++) {
            if(s.charAt(i) == 'O' && s.charAt(i - 1) == 'I' && s.charAt(i + 1) == 'I') {
                block++;
                if(block >= n) {
                    cnt++;
                    block--;
                }
                i = i + 1;
            } else {
                block = 0;
            }
        }
        System.out.println(cnt);
    }
}