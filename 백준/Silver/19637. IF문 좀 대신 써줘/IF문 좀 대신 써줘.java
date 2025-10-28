import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeMap<Integer, String> tm = new TreeMap<>();
//        String[] cond = new String[n];
//        int[] rec = new int[n];
//
//        int ptr = 0;
//        for(int i = 0 ; i < m ; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//
//            String s = st.nextToken();
//            int v = Integer.parseInt(st.nextToken());
//
//            if(ptr == 0) {
//                cond[ptr] = s;
//                rec[ptr] = v;
//                ptr++;
//                continue;
//            }
//
//            if(rec[ptr - 1] == v) continue;
//            //값이 같으면 먼저 등장한거만 주므로, 같으면 저장할 필요 없이 넘김
//
//            cond[ptr] = s;
//            rec[ptr] = v;
//            ptr++;
//        }

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String v = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            if(!tm.containsKey(k)) tm.put(k, v);
        }

        for(int i = 0 ; i < m ; i++) {
            int v = Integer.parseInt(br.readLine());

            int k = tm.ceilingKey(v);
            sb.append(tm.get(k)).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}