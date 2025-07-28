import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>((int) (n * 1.3));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++) {
            int tok = Integer.parseInt(st.nextToken());
            if(hm.containsKey(tok)) {
                hm.put(tok, hm.get(tok) + 1);
            } else {
                hm.put(tok, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m ; i++) {
            int tok = Integer.parseInt(st.nextToken());
            if(hm.containsKey(tok)) {
                sb.append(hm.get(tok)).append(" ");
            } else {
                sb.append("0 ");
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}