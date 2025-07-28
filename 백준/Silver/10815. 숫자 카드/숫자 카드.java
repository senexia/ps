import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cds = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<Integer> s = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < cds ; i++) {
            s.add(Integer.parseInt(st.nextToken()));
        }

        int tc = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < tc ; i++) {
            int ipt = Integer.parseInt(st.nextToken());
            if(i != tc - 1) {
                if(s.contains(ipt)) sb.append("1 ");
                else sb.append("0 ");
            } else {
                if(s.contains(ipt)) sb.append("1");
                else sb.append("0");
            }

        }
        System.out.println(sb);
//        bw.flush();
//        bw.close();
    }
}