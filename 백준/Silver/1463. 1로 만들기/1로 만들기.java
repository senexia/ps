import java.io.*;
import java.util.*;

public class Main {
    public static int dp(int n, int[] op) {
        for(int i = 2 ; i <= n ; i++) {
            op[i] = op[i-1] + 1;
            if(i % 2 == 0 && op[i/2] + 1 < op[i]) {
                op[i] = op[i/2] + 1;
            }
            if(i % 3 == 0 && op[i/3] + 1 < op[i]) {
                op[i] = op[i/3] + 1;
            }
        }
        return op[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] op = new int[num + 1];
        op[1] = 0;
        bw.write(String.valueOf(dp(num, op)));
        bw.flush();
        bw.close();
    }
}