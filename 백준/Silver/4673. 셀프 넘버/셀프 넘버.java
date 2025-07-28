import java.io.*;
import java.util.*;

public class Main {
    public static int sn(int n) {
        int ret = n;
        while(n > 0) {
            ret += n % 10;
            n /= 10;
        }
        return ret;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] v = new boolean[10001];
        for(int i = 1 ; i < 10000 ; i++) {
            if(sn(i) < 10000) v[sn(i)] = true;
        }
        for(int i = 1 ; i < 10000 ; i++) {
            if(!v[i]) bw.write(String.valueOf(i) + "\n");
        }


        bw.flush();
        bw.close();
    }
}