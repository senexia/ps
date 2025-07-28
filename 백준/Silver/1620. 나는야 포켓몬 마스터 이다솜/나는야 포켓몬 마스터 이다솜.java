import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> m1 = new HashMap<>();
        HashMap<String, Integer> m2 = new HashMap<>();

        for(int i = 0 ; i < n ; i++) {
            String pokemon = br.readLine();
            m1.put(i+1, pokemon);
            m2.put(pokemon, i+1);
        }

        for(int i = 0 ; i < m ; i++) {
            String s = br.readLine();
            Character c = s.charAt(0);
            if(0 <= c - '0' && c - '0' <= 9) {
                bw.write(m1.get(Integer.parseInt(s)) + "\n");
            } else {
                bw.write(String.valueOf(m2.get(s)) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}