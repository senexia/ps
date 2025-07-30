
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < tc ; i++) {
            int n = Integer.parseInt(br.readLine());
            for(int j = 2 ;; j++) {
                int cnt = 0;
                while(true) {
                    if(n % j == 0) {
                        cnt++;
                        n /= j;
                    } else {
                        break;
                    }
                }
                if(cnt != 0) {
                    sb.append(j).append(" ").append(cnt).append("\n");
                }
                if(n == 1) break;
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}