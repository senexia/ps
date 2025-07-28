import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*String sheet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] ipt = br.readLine().split(" ");
        String in = ipt[0];
        int how = Integer.parseInt(ipt[1]);
        int res = 0;

        for(int i = in.length() - 1 ; i >= 0 ; i--) {
            int k = sheet.indexOf(in.charAt(i));
            res += Math.pow()
        }*/

        String[] ipt = br.readLine().split(" ");
        int a = Integer.parseInt(ipt[0]);
        int b = Integer.parseInt(ipt[1]);
        int v = Integer.parseInt(ipt[2]);

        int div = (v-b) / (a-b);
        if(v-b == div * (a-b)) bw.write(String.valueOf(div));
        else bw.write(String.valueOf(1+div));




        bw.flush();
        bw.close();
    }
}