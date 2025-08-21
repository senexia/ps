import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        double tot = 0;
        HashMap<String, Integer> hm = new HashMap<>();
        while(true) {
            String s = br.readLine();
            if(s == null || s.isEmpty()) break;
            hm.put(s, hm.getOrDefault(s, 0) + 1);
            tot++;
        }

        TreeMap<String, Integer> tm = new TreeMap<>(hm);
//        System.out.println(tm);

        while(!tm.isEmpty()) {
            String fk = tm.firstKey();
            double cnt = tm.get(fk);

            double val = (cnt / tot) * 100;

            sb.append(fk).append(" ").append(String.format("%.4f", val)).append("\n");
            tm.remove(fk);
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
//        System.out.println("tot = " + tot);
    }
}