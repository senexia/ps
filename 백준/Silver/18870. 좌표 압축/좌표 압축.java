import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String ipt = br.readLine();
        TreeSet<Integer> ts = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(ipt, " ");
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for(int i = 0 ; i < n ; i++) {
            ts.add(Integer.parseInt(st.nextToken()));
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        while(!ts.isEmpty()) {
            hm.put(ts.pollFirst(), idx);
            idx++;
        }

        st = new StringTokenizer(ipt, " ");
        for(int i = 0 ; i < n ; i++) {
            sb.append(hm.get(Integer.parseInt(st.nextToken())));
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}