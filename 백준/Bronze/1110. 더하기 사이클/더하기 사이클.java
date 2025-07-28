import java.io.*;
import java.util.*;

public class Main {
    public static int cyc(int x) {
        int n = x;
        if(n < 10) n *= 10;
        int digitSum = 0;
        int fd = x % 10;
        while(n > 0) {
            digitSum += n % 10;
            n /= 10;
        }
        return 10 * fd + (digitSum % 10);
    }
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ipt = Integer.parseInt(br.readLine());
        int cnt = 0;
        int x = ipt;
        while(true) {
            cnt++;
            ipt = cyc(ipt);
            if (x == ipt) break;
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}