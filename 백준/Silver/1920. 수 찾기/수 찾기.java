import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            map.put(Integer.parseInt(st.nextToken()), true);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int cnt = 0;
        for(int i = 0 ; i < m ; i++) {
            if(map.containsKey(Integer.parseInt(st.nextToken()))) bw.write("1\n");
            else bw.write("0\n");
        }


        bw.flush();
        bw.close();
    }
}
