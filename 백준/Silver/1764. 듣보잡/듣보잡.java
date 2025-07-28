import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> s1 = new HashSet<>();
        HashSet<String> s2 = new HashSet<>();
        HashSet<String> s3 = new HashSet<>();


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < n ; i++) {
            s1.add(br.readLine());
        }
        for(int i = 0 ; i < m ; i++) {
            s2.add(br.readLine());
        }
        if(n > m) {
            for(String s : s2) {
                if(s1.contains(s)) s3.add(s);
            }
        } else {
            for(String s : s1) {
                if(s2.contains(s)) s3.add(s);
            }
        }
        List<String> l = new ArrayList<>(s3);
        Collections.sort(l);
        bw.write(String.valueOf(l.size()) + "\n");
        for(String s : l) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }
}