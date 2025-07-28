import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        TreeMap<Integer, TreeMap<Integer, String>> map = new TreeMap<>();
        StringTokenizer st;

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            map.putIfAbsent(age, new TreeMap<>());
            map.get(age).put(i, name);
        }

        while(!map.isEmpty()) {
            int k1 = map.firstKey();
            TreeMap<Integer, String> temp = map.get(k1);
            while(!temp.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                int k2 = temp.firstKey();
                String name = temp.get(k2);
                sb.append(k1).append(" ").append(name);
                System.out.println(sb);
                temp.remove(k2);
            }
            map.remove(k1);
        }
    }
}