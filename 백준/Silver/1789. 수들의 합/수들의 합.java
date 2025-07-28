import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long ipt = Long.parseLong(br.readLine());
        int ret = 0;
        long sum = 0;
        if(ipt == 1) {
            ret = 1;
        } else {
            for(int i = 1 ; ;i++) {
                sum += i;
                if(sum > ipt) {
                    ret = i - 1;
                    break;
                }
            }
        }

        bw.write(String.valueOf(ret));




        bw.flush();
        bw.close();
    }
}