import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, String> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] ipt = new String[2];

        for(int i = 0 ; i < n ; i++) {
            ipt = br.readLine().split(" ");
            map.put(ipt[0], ipt[1]);
        }

        for(int i = 0 ; i < m ; i++) {
            String pwl = br.readLine();
            if(map.containsKey(pwl)) {
                bw.write(map.get(pwl) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
