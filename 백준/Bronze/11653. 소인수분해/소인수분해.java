
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        if(n == 1) return;

        for(int i = 2;;i++) {
            while(true) {
                if(n % i == 0) {
                    sb.append(i).append("\n");
                    n /= i;
                } else {
                    break;
                }
            }
            if(n == 1) break;
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}