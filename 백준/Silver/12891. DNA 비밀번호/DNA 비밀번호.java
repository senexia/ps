import java.io.*;
import java.util.*;

public class Main {
    static int[] alpcnt;
    static int n1, n2, n3, n4;
    static boolean check() {
        if(alpcnt[0] >= n1
        && alpcnt[1] >= n2
        && alpcnt[2] >= n3
        && alpcnt[3] >= n4) return true;
        else return false;
    }

    static void inc(char c) {
        if(c == 'A') alpcnt[0]++;
        if(c == 'C') alpcnt[1]++;
        if(c == 'G') alpcnt[2]++;
        if(c == 'T') alpcnt[3]++;
    }
    static void dec(char c) {
        if(c == 'A') alpcnt[0]--;
        if(c == 'C') alpcnt[1]--;
        if(c == 'G') alpcnt[2]--;
        if(c == 'T') alpcnt[3]--;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        alpcnt = new int[4];
        String str = br.readLine();

        st = new StringTokenizer(br.readLine(), " ");
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
        n3 = Integer.parseInt(st.nextToken());
        n4 = Integer.parseInt(st.nextToken());

        int s = 0;
        int e = s + m - 1;

        int cnt = 0;
        for(int i = s ; i <= e ; i++) {
            inc(str.charAt(i));
        }
        if(check()) cnt++;
        while(e < n - 1) {
            dec(str.charAt(s++));
            inc(str.charAt(++e));
            if(check()) cnt++;
        }
        System.out.println(cnt);
    }
}