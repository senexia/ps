import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < tc ; t++) {
            HashSet<Integer> hs = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < n ; i++) {
                hs.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < m ; i++) {
                sb.append(hs.contains(Integer.parseInt(st.nextToken())) ? "1\n" : "0\n");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}