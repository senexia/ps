import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int op = Integer.parseInt(br.readLine());

        TreeMap<Integer, TreeSet<String>> m = new TreeMap<>();

        for(int i = 0 ; i < op ; i++) {
            String s = br.readLine();
            m.putIfAbsent(s.length(), new TreeSet<>());
            m.get(s.length()).add(s);
        }

        while(!m.isEmpty()) {
            int fk = m.firstKey();
            for(String s : m.get(fk)) {
                bw.write(s + "\n");
            }
            m.remove(fk);
        }


        bw.flush();
        bw.close();
    }
}