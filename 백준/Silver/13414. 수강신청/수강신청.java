import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>(500000 * 3 / 2);

        for(int i = 1 ; i <= l ; i++) {
            hm.put(br.readLine(), i);
        }

        TreeMap<Integer, String> tm = new TreeMap<>();
        for(Map.Entry<String, Integer> e : hm.entrySet()) {
            tm.put(e.getValue(), e.getKey());
        }

        for(int i = 0 ; i < k ; i++) {
            if(tm.isEmpty()) break;
            int fk = tm.firstKey();
            sb.append(tm.get(fk)).append("\n");
            tm.remove(fk);
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}