import java.util.*;
import java.io.*;

public class Main {
    static int[] d = new int[13];
    static void init(int n) {
        if(n <= 3) return;
        for(int i = 4 ; i <= n ; i++) {
            d[i] = d[i-1] + d[i-2] + d[i-3];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] ipt = new int[n];
        int max = -1;
        for(int i = 0 ; i < n ; i++) {
            ipt[i] = Integer.parseInt(br.readLine());
            if(max < ipt[i]) max = ipt[i];
        }
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;
        init(max);
        for(int i = 0 ; i < n ; i++) {
            bw.write(String.valueOf(d[ipt[i]]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
