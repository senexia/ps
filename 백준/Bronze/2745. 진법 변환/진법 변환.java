import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sheet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] ipt = br.readLine().split(" ");
        String in = ipt[0];
        int how = Integer.parseInt(ipt[1]);
        int res = 0;

        for(int i = in.length() - 1 ; i >= 0 ; i--) {
            int k = sheet.indexOf(in.charAt(i));
            res += (int)Math.pow(how, in.length() - i - 1) * k;
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }
}