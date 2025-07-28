import java.util.*;
import java.io.*;

public class Main {
    static String c(String s) {
        if(s.length() == 1) {
            return s;
        } else {
            int len = s.length();

            String temp = s.substring(0, len/3);
            return c(temp) + c(" ".repeat(len/3)) + c(temp);
//            return temp + " ".repeat(len/3) + temp;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String n = br.readLine();
            if(n == null) {
                break;
            }
            int i = Integer.parseInt(n);
            String str = "-".repeat((int)Math.pow(3, i));
            bw.write(c(str) + "\n");
        }

        bw.flush();
        bw.close();
    }
}