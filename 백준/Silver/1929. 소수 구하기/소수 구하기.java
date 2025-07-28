import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] p;
    public static void primeCalc(int n) {
        for(int i = 2 ; i * i <= n ; i++) {
            if(p[i]) {
                for(int j = 2 ; i * j <= n ; j++) {
                    p[i*j] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ipt = br.readLine().split(" ");
        int m = Integer.parseInt(ipt[0]);
        int n = Integer.parseInt(ipt[1]);

        p = new boolean[n + 1];
        Arrays.fill(p, true);
        p[0] = false;
        p[1] = false;
        primeCalc(n);
        for(int k = m ; k <= n ; k++) {
            if(p[k]) bw.write(String.valueOf(k) + "\n");
        }


        bw.flush();
        bw.close();
    }
}