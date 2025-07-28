import java.io.*;
import java.util.*;

public class Main {
    public static int fib[];
    public static int f(int n) {
        if(fib[n] != 0) return fib[n];
        else {
            fib[n] = f(n-1) + f(n-2);
            return fib[n];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        int[] ipt = new int[cnt];
        fib = new int[41];
        Arrays.fill(fib, 0);
        fib[1] = 1;
        fib[2] = 1;
        for(int i = 0 ; i < cnt ; i++) {
            ipt[i] = Integer.parseInt(br.readLine());
            if(ipt[i] == 0) bw.write("1 0\n");
            else if(ipt[i] == 1) bw.write("0 1\n");
            else if(ipt[i] == 2) bw.write("1 1\n");
            else {
                f(ipt[i]);
                bw.write(String.valueOf(fib[ipt[i]-1]) + " " + String.valueOf(fib[ipt[i]]) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}