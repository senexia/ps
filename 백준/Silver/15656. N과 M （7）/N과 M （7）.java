
import java.io.*;
import java.util.*;

public class Main {
    static int n, r;
    static int[] a, b;
//    static boolean[] v;
    static StringBuilder sb = new StringBuilder();
    static void perm(int cnt) {
        if(cnt == r) {
            for(int num : b) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0 ; i < n ; i++) {
//            if(v[i]) continue;
//            v[i] = true;
            b[cnt] = a[i];
            perm(cnt + 1);
//            v[i] = false;
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[r];
//        v = new boolean[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        perm(0);
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}