import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int[] arr;
    static int[] perm;
    static boolean[] v;
    static int res = -1;

    static void cal() {
        int s = 0;
        for(int i = 0 ; i < n - 1; i++) {
            s += Math.abs(perm[i] - perm[i + 1]);
        }
        if(res < s) res = s;
    }

    static void perm(int cnt) {
        if(cnt == n) {
            cal();
            return;
        }
        for(int i = 0 ; i < n ; i++) {
            if(v[i]) continue;
            v[i] = true;
            perm[cnt] = arr[i];
            perm(cnt + 1);
            v[i] = false;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        perm = new int[n];
        v = new boolean[n];

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        perm(0);
        System.out.println(res);
    }
}