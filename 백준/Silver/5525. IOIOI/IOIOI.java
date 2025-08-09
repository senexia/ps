import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String target = "IO".repeat(n) + "I";
        int cnt = 0;

        for(int i = 0 ; i <= s.length() - target.length() ; i++) {
            boolean b = true;
            if(s.charAt(i) == 'I') {
                for(int j = 1 ; j < target.length() ; j++) {
                    if(s.charAt(i + j) != target.charAt(j)) {
                        b = false;
                        break;
                    }
                }
                if(b) cnt++;
            }
        }
        System.out.println(cnt);
    }
}