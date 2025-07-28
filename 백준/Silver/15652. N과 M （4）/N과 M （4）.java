import java.io.*;
import java.util.*;

public class Main {
    static int n, r;
    static int[] a, b;
//    static boolean[] v;
    static StringBuilder sb = new StringBuilder();

    static void perm(int cnt, int st) {
        if(cnt == r) {
            for(int i : b) {
                sb.append(i).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
            return;
        }
        for(int i = st ; i < n ; i++) {
            b[cnt] = a[i];
            perm(cnt + 1, i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        a = new int[n];
        b = new int[r];
//        v = new boolean[n];
        for(int i = 0 ; i < n ; i++) {
            a[i] = i + 1;
        }

        perm(0, 0);
        System.out.print(sb);
    }
}