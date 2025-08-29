import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    static int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] perm;
    static char[] ineq;
    static boolean[] v;

    static String r1;
    static String r2;

    static void perm(int prev, int cnt, int ineqcnt) {
        if(cnt == n + 1) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < n + 1 ; i++) {
                sb.append(perm[i]);
            }
            long res = Long.parseLong(sb.toString());
            if(max < res) {
                max = res;
                r1 = sb.toString();
            }
            if(min > res) {
                min = res;
                r2 = sb.toString();
            }
            return;
        }

        for(int i = 0 ; i < 10 ; i++) {
            boolean legit = false;
            if(v[i]) continue;

            if(ineq[ineqcnt] == '>') {
                if(prev > a[i]) legit = true;
            } else {
                if(prev < a[i]) legit = true;
            }
            if(legit) {
                v[i] = true;
                perm[cnt] = a[i];
                perm(a[i], cnt + 1, ineqcnt + 1);
                v[i] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        perm = new int[n + 1];
        ineq = new char[n];
        v = new boolean[10];
        String s = br.readLine();
        for(int i = 0 ; i < n ; i++) {
            ineq[i] = s.charAt(2 * i);
        }
        for(int i = 0 ; i < 10 ; i++) {
            v[i] = true;
            perm[0] = a[i];
            perm(a[i], 1, 0);
            v[i] = false;
        }

//        int digitBound = n + 1;
//        String s1 = Long.toString(max);
//        String s2 = Long.toString(min);
//
//        int len1 = s1.length();
//        int len2 = s2.length();
//
//        if(digitBound > len1) {
//            for(int i = 0 ; i <= digitBound - len1 ; i++) {
//                sb.append(0);
//            }
//        }
//        sb.append(s1).append("\n");
//        if(digitBound > len2) {
//            for(int i = 0 ; i <= digitBound - len2 ; i++) {
//                sb.append(0);
//            }
//        }
//        sb.append(s2);
        sb.append(r1).append("\n").append(r2);
        System.out.print(sb);
    }
}