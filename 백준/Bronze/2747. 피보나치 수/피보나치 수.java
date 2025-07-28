import java.io.*;
import java.util.*;


public class Main {
    static int f[];
    public static int dp(int n) {
        if(f[n] != 0) return f[n];
        else {
            f[n] = dp(n-1) + dp(n-2);
            return f[n];
        }
    }
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        f = new int[46];
        f[1] = 1;
        f[2] = 1;
        if(n <= 2) bw.write(String.valueOf(1));
        else bw.write(String.valueOf(dp(n)));
        bw.flush();
        bw.close();

    }
}