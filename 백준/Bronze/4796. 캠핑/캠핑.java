
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if(l == 0) break;

            sb.append("Case ")
              .append(idx)
              .append(": ")
              .append(l * (v / p) + Math.min(l, v - (v / p) * p))
              .append("\n");
            idx++;
        }

        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}